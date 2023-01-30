package com.example.tripservicekata.trip;

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
        List<Trip> tripList = new ArrayList<>();
        User loggedUser = this.userSession.getLoggedUser();
        if (loggedUser != null) {
            if (user.isFriend(loggedUser)) {
                tripList = TripDAO.findTripsByUser(user);
            }
            return tripList;
        } else {
            throw new UserNotLoggedInException();
        }
    }

}
