package com.example.tripservicekata.trip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.example.tripservicekata.exception.UserNotLoggedInException;
import com.example.tripservicekata.user.User;
import com.example.tripservicekata.user.UserSession;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class TripServiceTest {

    MockedStatic<TripDAO> mTripDAO = mockStatic(TripDAO.class);

    @Test
    public void 여행_정보를_사용자를_통해_불러올_수_있다() {
        UserSession mUserSession = mock(UserSession.class);
        User friend = new User();
        when(mUserSession.getLoggedUser()).thenReturn(friend);

        List<Trip> retrieveTrips = new ArrayList<>();
        retrieveTrips.add(new Trip());
        mTripDAO.when(() -> TripDAO.findTripsByUser(any())).thenReturn(retrieveTrips);

        User user = new User();
        user.addFriend(friend);

        TripService tripService = new TripService(mUserSession);
        List<Trip> trips = tripService.getTripsByUser(user);
        assertThat(trips.size()).isEqualTo(1);
    }

    @Test
    public void 친구가_아니면_빈_여행_정보를_불러올_수_있다() {
        UserSession mUserSession = mock(UserSession.class);
        User user = new User();
        when(mUserSession.getLoggedUser()).thenReturn(user);

        List<Trip> retrieveTrips = new ArrayList<>();
        retrieveTrips.add(new Trip());
        mTripDAO.when(() -> TripDAO.findTripsByUser(any())).thenReturn(retrieveTrips);

        TripService tripService = new TripService(mUserSession);
        List<Trip> trips = tripService.getTripsByUser(user);
        assertThat(trips.size()).isEqualTo(0);
    }

    @Test
    public void 로그_유저가_NULL이면_예외를_발생시킬_수_있다() {
        UserSession mUserSession = mock(UserSession.class);
        when(mUserSession.getLoggedUser()).thenReturn(null);

        List<Trip> retrieveTrips = new ArrayList<>();
        retrieveTrips.add(new Trip());
        mTripDAO.when(() -> TripDAO.findTripsByUser(any())).thenReturn(retrieveTrips);

        TripService tripService = new TripService(mUserSession);
        assertThatThrownBy(() -> tripService.getTripsByUser(new User()))
            .isInstanceOf(UserNotLoggedInException.class);
    }
}
