package unitTests

import features.AuthResult

interface IAuthRepository {
    fun isAuthorized():Boolean
    fun init()
    fun signup(email: String, password: String) : AuthResult
}
