package com.cawadev.softwarecraft.katas.tripservice.trip;

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException;
import com.cawadev.softwarecraft.katas.tripservice.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.cawadev.softwarecraft.katas.tripservice.user.UserBuilder.builder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TripServiceTest {

    private TripService tripService;

    private User userLoggedIn;
    private static final User GUEST = null;
    private static final User ANY_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip PARIS = new Trip();
    private static final Trip LOS_ANGELES = new Trip();
    private static final Trip ROMA = new Trip();

    @BeforeEach
    void setUp() {
        tripService = new TripServiceStub();
        userLoggedIn = REGISTERED_USER;
    }

    @Test
    void should_not_validate_user_when_not_logged_in() {
        userLoggedIn = GUEST;

        assertThatExceptionOfType(UserNotLoggedInException.class)
                .isThrownBy(() -> tripService.getTripsByUser(ANY_USER));
    }

    @Test
    void should_not_return_trips_when_user_logged_in_are_not_friends() {
        User stranger = builder()
                .friendsWith(ANOTHER_USER)
                .withTrips(PARIS)
                .build();

        List<Trip> result = tripService.getTripsByUser(stranger);

        assertThat(result).isEmpty();
    }

    @Test
    void should_return_trips_when_user_logged_in_are_friends() {
        User friend = builder().friendsWith(REGISTERED_USER)
                .withTrips(LOS_ANGELES, ROMA)
                .build();

        List<Trip> result = tripService.getTripsByUser(friend);

        assertThat(result).containsExactlyInAnyOrder(LOS_ANGELES, ROMA);
    }

    class TripServiceStub extends TripService {

        @Override
        protected List<Trip> tripsByUser(User user) {
            return user.trips();
        }

        @Override
        protected User getLoggedUser() {
            return userLoggedIn;
        }
    }
}
