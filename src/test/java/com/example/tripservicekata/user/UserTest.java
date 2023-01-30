package com.example.tripservicekata.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tripservicekata.trip.Trip;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void 여행_정보를_추가하고_불러올_수_있다() {
        User user = new User();
        user.addTrip(new Trip());
        List<Trip> trips = user.trips();
        assertThat(trips.size()).isEqualTo(1);
    }

    @Test
    public void 친구_정보를_추가하고_불러올_수_있다() {
        User user = new User();
        user.addFriend(new User());
        List<User> friends = user.getFriends();
        assertThat(friends.size()).isEqualTo(1);
    }

}
