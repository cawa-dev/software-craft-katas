package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException
import com.cawadev.softwarecraft.katas.tripservice.user.User
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.test.assertContains

class TripServiceTest {

    private lateinit var tripDAO: TripDAO

    private lateinit var tripService: TripService

    companion object {
        private val GUEST: User? = null
        private val ANY_USER = User()
        private val REGISTERED_USER = User()
        private val ANOTHER_USER = User()
        private val PARIS = Trip()
    }

    @BeforeEach
    fun setUp() {
        tripDAO = mock()
        tripService = TripService(tripDAO)
    }

    @Test
    fun `should not validate the user when not logged in`() {
        assertThrows<UserNotLoggedInException> {
            tripService.getTripsByUser(ANY_USER, GUEST)
        }
    }

    @Test
    fun `should return empty trips when user logged in is not a friend`() {
        val stranger = User().apply {
            addFriend(ANOTHER_USER)
            addTrip(PARIS)
        }

        val trips = tripService.getTripsByUser(stranger, REGISTERED_USER)

        assert(trips.isEmpty())
    }

    @Test
    fun `should return trips when user logged in is a friend`() {
        val friend = User().apply {
            addFriend(REGISTERED_USER)
            addTrip(PARIS)
        }
        `when`(tripDAO.tripsByUser(friend)).thenReturn(listOf(PARIS))

        val trips = tripService.getTripsByUser(friend, REGISTERED_USER)

        assert(trips.isNotEmpty())
        assertContains(trips, PARIS)
    }
}
