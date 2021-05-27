package cucumber.features

import features.AuthResult
import features.InMemoryAuthRepository
import unitTests.IAuthRepository
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert
import kotlin.test.assertFails
import kotlin.test.assertTrue

class SignupTest {

    private lateinit var repository: InMemoryAuthRepository

    @Given(": The app is in unauthorized state!")
    fun the_app_is_in_unauthorized_state() {
        repository = InMemoryAuthRepository()
        Assert.assertEquals(repository.isAuthorized(), false)
    }

    @Then(": I submit the {string} and a {string}")
    fun iEnterAnAndA(email: String?, password: String?) {
        val signupResult = repository.signup(email!!, password!!)
        Assert.assertTrue(signupResult is AuthResult.Success)
    }


    @Then(": I submit invalid {string} and a {string}")
    fun iEnterInvalidAnAndA(email: String?, password: String?) {
        val signupResult = repository.signup(email!!, password!!)
        Assert.assertTrue(signupResult is AuthResult.ValidationError)
    }

    @Then(": I should no longer be unauthorized.")
    fun i_should_no_longer_be_unauthorized() {
        Assert.assertEquals(repository.isAuthorized(), true)
    }

    @Then(": I should be unauthorized.")
    fun i_should_be_unauthorized() {
        Assert.assertEquals(repository.isAuthorized(), false)
    }
}