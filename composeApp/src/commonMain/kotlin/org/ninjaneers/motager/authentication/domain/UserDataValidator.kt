package org.ninjaneers.motager.authentication.domain

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

    fun onPasswordValidate(password: String): Result<Unit, UserDataError> {
        if (password.isEmpty())
            return Result.Error(UserDataError.PASSWORD_IS_EMPTY)
        if (password.length < 8)
            return Result.Error(UserDataError.IS_TOO_SHORT)
        return Result.Success(Unit)
    }

    fun onConfirmPasswordValidate(
        password: String,
        confirmedPassword: String
    ): Result<Unit, UserDataError> {
        if (password != confirmedPassword)
            return Result.Error(UserDataError.PASSWORDS_MISMATCH)
        return Result.Success(Unit)
    }

    fun onNamesValidate(name: String): Result<Unit, UserDataError> {
        if (name.isEmpty())
            return Result.Error(UserDataError.NAME_IS_EMPTY)
        return Result.Success(Unit)
    }


    enum class UserDataError : Error {
        EMAIL_IS_EMPTY,
        INVALID_EMAIL,
        PASSWORD_IS_EMPTY,
        IS_TOO_SHORT,
        PASSWORDS_MISMATCH,
        NAME_IS_EMPTY
    }
}