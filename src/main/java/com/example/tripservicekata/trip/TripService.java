package com.example.tripservicekata.trip;

import static java.util.Objects.isNull;

import com.example.tripservicekata.exception.UserNotLoggedInException;
import com.example.tripservicekata.user.User;
import com.example.tripservicekata.user.UserSession;
import java.util.ArrayList;
import java.util.List;

public class TripService {

    private final UserSession userSession;

    public TripService(UserSession userSession) {
        this.userSession = userSession;
    }

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> trips;
        User loggedUser = this.userSession.getLoggedUser();
        if (isNull(loggedUser)) {
            throw new UserNotLoggedInException();
        }
        if (user.isFriend(loggedUser)) {
            trips = TripDAO.findTripsByUser(user);
        } else {
            trips = new ArrayList<>();
        }
        return trips;
    }

}
