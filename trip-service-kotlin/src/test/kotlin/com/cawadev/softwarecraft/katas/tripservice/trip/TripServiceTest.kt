package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException
import com.cawadev.softwarecraft.katas.tripservice.user.User
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertContains

class TripServiceTest {

    private lateinit var service: TripService
    private var loggedInUser: User? = null

    companion object {
        private val GUEST: User? = null
        private val ANY_USER = User()
        private val REGISTERED_USER = User()
        private val ANOTHER_USER = User()
        private val PARIS = Trip()
    }

    @BeforeEach
    fun setUp() {
        service = TripServiceStub()
        loggedInUser = REGISTERED_USER
    }

    @Test
    fun `should not validate the user when not logged in`() {
        loggedInUser = GUEST

        assertThrows<UserNotLoggedInException> {
            service.getTripsByUser(ANY_USER)
        }
    }

    @Test
    fun `should return empty trips when user logged in is not a friend`() {
        val stranger = User().apply {
            addFriend(ANOTHER_USER)
            addTrip(PARIS)
        }

        val trips = service.getTripsByUser(stranger)

        assert(trips.isEmpty())
    }

    @Test
    fun `should return trips when user logged in is a friend`() {
        val friend = User().apply {
            addFriend(REGISTERED_USER)
            addTrip(PARIS)
        }

        val trips = service.getTripsByUser(friend)

        assert(trips.isNotEmpty())
        assertContains(trips, PARIS)
    }

    inner class TripServiceStub : TripService() {

        override fun tripsByUser(user: User): List<Trip> =
            user.trips

        override fun getLoggedInUser(): User? = loggedInUser
    }
}
