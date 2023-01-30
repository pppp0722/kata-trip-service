package com.example.tripservicekata;

import com.example.tripservicekata.exception.UserNotLoggedInException;
import com.example.tripservicekata.trip.Trip;
import com.example.tripservicekata.trip.TripDAO;
import com.example.tripservicekata.trip.TripService;
import com.example.tripservicekata.user.User;
import com.example.tripservicekata.user.UserSession;
import java.util.ArrayList;
import java.util.List;

public class TripService_Original {

    private final TripService tripService;

    private final UserSession userSession;

    public TripService_Original(UserSession userSession, TripService tripService) {
        this.userSession = userSession;
        this.tripService = tripService;
    }

}
