package com.cawadev.softwarecraft.katas.tripservice.user;

import org.junit.jupiter.api.Test;

import static com.cawadev.softwarecraft.katas.tripservice.user.UserBuilder.builder;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private static final User PAUL = new User();
    private static final User JACQUES = new User();

    @Test
    void should_return_true_when_user_is_friends_with_another_user() {
        var user = builder().friendsWith(PAUL).build();

        assertThat(user.isFriendsWith(PAUL)).isTrue();
        assertThat(user.isFriendsWith(JACQUES)).isFalse();
    }
}
