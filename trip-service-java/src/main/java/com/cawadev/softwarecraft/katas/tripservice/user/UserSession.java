package com.cawadev.softwarecraft.katas.tripservice.user;

import com.cawadev.softwarecraft.katas.tripservice.exception.CollaboratorCallException;

public class UserSession {

    private static UserSession USER_SESSION;

    private UserSession() {
    }

    public static synchronized UserSession getInstance() {
        if (USER_SESSION == null) {
            return new UserSession();
        }

        return USER_SESSION;
    }

    public User getLoggedUser() {
        throw new CollaboratorCallException(
                "UserSession.getLoggedUser() should not be called in an unit test");
    }
}
