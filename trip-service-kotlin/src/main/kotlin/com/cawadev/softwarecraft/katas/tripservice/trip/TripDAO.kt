package com.cawadev.softwarecraft.katas.tripservice.trip

import com.cawadev.softwarecraft.katas.tripservice.exception.CollaboratorCallException
import com.cawadev.softwarecraft.katas.tripservice.user.User

class TripDAO {

    companion object {
        @JvmStatic
        fun findTripsByUser(user: User): List<Trip> {
            throw CollaboratorCallException("TripDAO should not be invoked on an unit test.")
        }
    }
}
