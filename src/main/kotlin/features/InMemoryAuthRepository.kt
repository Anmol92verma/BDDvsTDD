package features

import unitTests.IAuthRepository
import java.util.regex.Pattern

class InMemoryAuthRepository : IAuthRepository {

    private lateinit var users: MutableList<User>

    init {
        init()
    }

    override fun init() {
        users = mutableListOf()
    }

    override fun isAuthorized(): Boolean {
        return users.isNotEmpty()
    }

    override fun signup(email: String, password: String): AuthResult {
        if (!email.isValidEmail()) {
            return AuthResult.ValidationError
        }
        if (!password.isValidPassword()) {
            return AuthResult.ValidationError
        }
        users.add(User(email, password))
        return AuthResult.Success
    }
}

private fun String.isValidPassword(): Boolean {
    val regex =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    return Pattern.matches(regex, this)
}

private fun String.isValidEmail(): Boolean {
    val regex = "^(.+)@(\\S+)$";
    return Pattern.matches(regex, this)
}
