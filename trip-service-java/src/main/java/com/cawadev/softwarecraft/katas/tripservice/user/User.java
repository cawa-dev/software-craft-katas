package com.cawadev.softwarecraft.katas.tripservice.user;

import com.cawadev.softwarecraft.katas.tripservice.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Trip> trips = new ArrayList<>();
    private final List<User> friends = new ArrayList<>();

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public boolean isFriendsWith(User anotherUser) {
        return friends.contains(anotherUser);
    }
}
