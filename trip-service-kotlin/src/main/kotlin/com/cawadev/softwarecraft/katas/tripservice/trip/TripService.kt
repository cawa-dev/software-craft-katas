package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException
import com.cawadev.softwarecraft.katas.tripservice.user.User
import com.cawadev.softwarecraft.katas.tripservice.user.UserSession

open class TripService {

    fun getTripsByUser(user: User): List<Trip> {
        val loggedUser: User? = getLoggedInUser()
        if (loggedUser === null) {
            throw UserNotLoggedInException()
        }

        return if (user.isFriendsWith(loggedUser)) {
            tripsByUser(user)
        } else emptyList()
    }

    open fun tripsByUser(user: User) = TripDAO.findTripsByUser(user)

    open fun getLoggedInUser(): User? = UserSession.instance.loggedUser
}
