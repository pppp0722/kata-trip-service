package com.example.tripservicekata.user;

import com.example.tripservicekata.trip.Trip;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<User> friends = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();

    public List<User> getFriends() {
        return this.friends;
    }

    public List<Trip> trips() {
        return this.trips;
    }

    public void addFriend(User user) {
        this.friends.add(user);
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public boolean isFriend(User user) {
        return this.getFriends().stream().anyMatch(user::equals);
    }

}
