package com.cawadev.softwarecraft.katas.tripservice.user

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UserTest {

    companion object {
        private val PAUL = User()
        private val TRISHA = User()
    }

    @Test
    fun `should return true when user are friends`() {
        val user = User().apply {
            addFriend(PAUL)
        }

        assertTrue(user.isFriendsWith(PAUL));
    }

    @Test
    fun `should return false when user are not friends`() {
        val user = User()

        assertFalse(user.isFriendsWith(TRISHA));
    }
}
