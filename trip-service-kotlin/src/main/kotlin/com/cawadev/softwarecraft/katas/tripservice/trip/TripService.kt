package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException
import com.cawadev.softwarecraft.katas.tripservice.user.User

class TripService(private val tripDAO: TripDAO) {

    fun getTripsByUser(
        user: User,
        loggedInUser: User?
    ): List<Trip> {
        if (loggedInUser === null) {
            throw UserNotLoggedInException()
        }

        return if (user.isFriendsWith(loggedInUser)) {
            tripsByUser(user)
        } else emptyList()
    }

    private fun tripsByUser(user: User) = tripDAO.tripsByUser(user)
}
