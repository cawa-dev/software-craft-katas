package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException
import com.cawadev.softwarecraft.katas.tripservice.user.User
import com.cawadev.softwarecraft.katas.tripservice.user.UserSession

open class TripService {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User? = getLoggedInUser()
        var isFriend: Boolean = false
        if (loggedUser != null) {
            for (friend in user.friends) {
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = tripsByUser(user)
            }
            return tripList
        } else {
            throw UserNotLoggedInException()
        }
    }

    open fun tripsByUser(user: User) = TripDAO.findTripsByUser(user)

    open fun getLoggedInUser(): User? = UserSession.instance.loggedUser
}
