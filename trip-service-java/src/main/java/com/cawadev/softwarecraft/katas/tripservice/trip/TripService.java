package com.cawadev.softwarecraft.katas.tripservice.trip;

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException;
import com.cawadev.softwarecraft.katas.tripservice.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private final TripDAO tripDAO;

    public TripService() {
        tripDAO = new TripDAO();
    }

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }

        return user.isFriendsWith(loggedUser)
                ? tripsByUser(user) :
                new ArrayList<>();
    }

    protected List<Trip> tripsByUser(User user) {
        return tripDAO.tripsByUser(user);
    }
}
