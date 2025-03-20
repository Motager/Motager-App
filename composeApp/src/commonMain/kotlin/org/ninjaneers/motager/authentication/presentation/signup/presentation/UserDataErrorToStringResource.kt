package org.ninjaneers.motager.authentication.presentation.signup.presentation

import motager.composeapp.generated.resources.Confirmed_Password_Mismatch
import motager.composeapp.generated.resources.Email_Is_Empty
import motager.composeapp.generated.resources.Invalid_Email
import motager.composeapp.generated.resources.Name_Is_Empty
import motager.composeapp.generated.resources.Password_Is_Empty
import motager.composeapp.generated.resources.Password_Is_Short
import motager.composeapp.generated.resources.Res
import org.ninjaneers.motager.authentication.presentation.signup.domain.UserDataValidator
import org.ninjaneers.motager.core.domain.UiText

fun UserDataValidator.UserDataError.toUiText(): UiText {
    val stringRes = when (this) {
        UserDataValidator.UserDataError.EMAIL_IS_EMPTY -> Res.string.Email_Is_Empty
        UserDataValidator.UserDataError.INVALID_EMAIL -> Res.string.Invalid_Email
        UserDataValidator.UserDataError.PASSWORD_IS_EMPTY -> Res.string.Password_Is_Empty
        UserDataValidator.UserDataError.IS_TOO_SHORT -> Res.string.Password_Is_Short
        UserDataValidator.UserDataError.PASSWORDS_MISMATCH -> Res.string.Confirmed_Password_Mismatch
        UserDataValidator.UserDataError.NAME_IS_EMPTY -> Res.string.Name_Is_Empty
    }
    return UiText.StringResourceId(stringRes)
}
