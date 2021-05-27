package features

sealed class AuthResult {
    object Success:AuthResult()
    object Failure:AuthResult()
    object ValidationError : AuthResult()
}
