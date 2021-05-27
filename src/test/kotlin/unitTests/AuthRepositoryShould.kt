package unitTests

import features.AuthResult
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class AuthRepositoryShould {

    @MockK
    lateinit var iAuthRepository: IAuthRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `try init() InitException`() {
        every {
            iAuthRepository.init()
        } throws InitException()

        assertFailsWith<InitException> {
            iAuthRepository.init()
        }
    }

    @Test
    fun `try init() with success`() {
        every {
            iAuthRepository.init()
        } returns Unit

        assert(iAuthRepository.init() == Unit)
    }

    @Test
    fun `return false when not authorized`() {
        every {
            iAuthRepository.isAuthorized()
        } returns false
        assert(!iAuthRepository.isAuthorized())
    }

    @Test
    fun `return true when authorized`() {
        every {
            iAuthRepository.isAuthorized()
        } returns true
        assert(iAuthRepository.isAuthorized())
    }

    @Test
    fun `return success when signup`() {
        every {
            iAuthRepository.signup(any(), any())
        } returns AuthResult.Success
        assert(iAuthRepository.signup("", "") is AuthResult.Success)
    }

    @Test
    fun `return failure when signup`() {
        every {
            iAuthRepository.signup(any(), any())
        } returns AuthResult.Failure
        assert(iAuthRepository.signup("", "") is AuthResult.Failure)
    }
}