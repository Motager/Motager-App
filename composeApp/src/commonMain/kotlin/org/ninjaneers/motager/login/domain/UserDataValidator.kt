package org.ninjaneers.motager.login.domain

import org.ninjaneers.motager.core.domain.Error
import org.ninjaneers.motager.core.domain.Result


class UserDataValidator {
    private val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()

    fun onEmailValidate(email: String): Result<Unit, UserDataError> {
        if (email.isEmpty())
            return Result.Error(UserDataError.EMAIL_IS_EMPTY)
        if (!emailRegex.matches(email))
            return Result.Error(UserDataError.INVALID_EMAIL)
        return Result.Success(Unit)

    }

    enum class UserDataError : Error {
        EMAIL_IS_EMPTY,
        INVALID_EMAIL,
        PASSWORD_IS_EMPTY,
    }
}