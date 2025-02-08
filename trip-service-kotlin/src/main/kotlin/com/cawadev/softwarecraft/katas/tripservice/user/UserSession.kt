package com.cawadev.softwarecraft.katas.tripservice.user

import com.cawadev.softwarecraft.katas.tripservice.exception.CollaboratorCallException

class UserSession private constructor() {

    companion object {
        @JvmStatic
        val instance = UserSession()
    }

    val loggedUser: User
        get() = throw CollaboratorCallException("UserSession.getLoggedUser() should not be called in an unit test")
}
