package fmt.kotlin.fundamentals

import fmt.kotlin.fundamentals.UserRole.OWNER

object Session {
    var currentUser = User("bmagrez", OWNER)
}

data class User(
    val login: String,
    val role: UserRole
)

enum class UserRole {
    OWNER,
    BUYER
}

class UnauthorizedException(login: String) : RuntimeException("Can't touch this: $login")