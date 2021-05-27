package features

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class SignupTest {
    @Given(": The app is in unauthorized state!")
    fun the_app_is_in_unauthorized_state() {
    }

    @When(": I Launch the App!")
    fun i_launch_the_app() {
    }

    @Then(": I enter an {string} and a {string}")
    fun iEnterAnAndA(email: String?, password: String?) {
    }

    @Then(": I have the option to signup!")
    fun i_have_the_option_to_signup() {
    }

    @Then(": I submit the details")
    fun i_submit_the_details() {
    }

    @Then(": I should no longer be unauthorized.")
    fun i_should_no_longer_be_unauthorized() {
    }
}