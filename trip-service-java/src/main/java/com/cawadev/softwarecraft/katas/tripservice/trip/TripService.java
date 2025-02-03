package com.cawadev.softwarecraft.katas.tripservice.trip;

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException;
import com.cawadev.softwarecraft.katas.tripservice.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private final TripDAO tripDAO;

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
        validate(loggedUser);

        return user.isFriendsWith(loggedUser)
                ? tripsByUser(user)
                : noTrips();
    }

    private ArrayList<Trip> noTrips() {
        return new ArrayList<>();
    }

    private void validate(User loggedUser) {
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    protected List<Trip> tripsByUser(User user) {
        return tripDAO.tripsByUser(user);
    }
}
