package com.example.tripservicekata.user;

import com.example.tripservicekata.trip.Trip;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<User> friends = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();

    public List<User> getFriends() {
        return friends;
    }

    public List<Trip> trips() {
        return trips;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public boolean isFriend(User user) {
        return this.getFriends().stream().anyMatch(user::equals);
    }

}
