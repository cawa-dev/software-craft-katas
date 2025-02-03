package com.cawadev.softwarecraft.katas.tripservice.trip;

import com.cawadev.softwarecraft.katas.tripservice.exception.UserNotLoggedInException;
import com.cawadev.softwarecraft.katas.tripservice.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.cawadev.softwarecraft.katas.tripservice.user.UserBuilder.builder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {

    TripService tripService;

    @Mock
    TripDAO tripDAO;

    private static final User GUEST = null;
    private static final User ANY_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip PARIS = new Trip();
    private static final Trip LOS_ANGELES = new Trip();
    private static final Trip ROMA = new Trip();

    @BeforeEach
    void setUp() {
        tripService = new TripService(tripDAO);
    }

    @Test
    void should_not_validate_user_when_not_logged_in() {
        assertThatExceptionOfType(UserNotLoggedInException.class)
                .isThrownBy(() -> tripService.getTripsByUser(ANY_USER, GUEST));
    }

    @Test
    void should_not_return_trips_when_user_logged_in_are_not_friends() {
        User stranger = builder()
                .friendsWith(ANOTHER_USER)
                .withTrips(PARIS)
                .build();

        List<Trip> result = tripService.getTripsByUser(stranger, REGISTERED_USER);

        assertThat(result).isEmpty();
    }

    @Test
    void should_return_trips_when_user_logged_in_are_friends() {
        Trip[] trips = {LOS_ANGELES, ROMA};
        User friend = builder().friendsWith(REGISTERED_USER)
                .withTrips(trips)
                .build();

        when(tripService.tripsByUser(friend)).thenReturn(List.of(trips));
        List<Trip> result = tripService.getTripsByUser(friend, REGISTERED_USER);

        assertThat(result).containsExactlyInAnyOrder(trips);
    }
}
