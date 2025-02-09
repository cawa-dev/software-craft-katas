package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException
import com.cawadev.softwarecraft.katas.tripservice.user.User

open class TripService {

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

    open fun tripsByUser(user: User) = TripDAO.findTripsByUser(user)
}
