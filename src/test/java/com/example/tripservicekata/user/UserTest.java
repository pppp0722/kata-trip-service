package com.example.tripservicekata.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tripservicekata.trip.Trip;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void 여행_정보를_추가하고_불러올_수_있다() {
        // given
        User user = new User();
        user.addTrip(new Trip());

        // when
        List<Trip> trips = user.trips();

        // then
        assertThat(trips.size()).isEqualTo(1);
    }

    @Test
    public void 친구_정보를_추가하고_불러올_수_있다() {
        // given
        User user = new User();
        user.addFriend(new User());

        // when
        List<User> friends = user.getFriends();

        // then
        assertThat(friends.size()).isEqualTo(1);
    }

    @Test
    public void 사용자의_친구인지_확인할_수_있다() {
        // given
        User user = new User();
        User friend = new User();
        user.addFriend(friend);

        // when
        boolean isFriend = user.isFriend(friend);

        // then
        assertThat(isFriend).isEqualTo(true);
    }

}
