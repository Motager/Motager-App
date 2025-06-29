package org.ninjaneers.motager.login.presentation.components

import motager.composeapp.generated.resources.Email_Is_Empty
import motager.composeapp.generated.resources.Invalid_Email
import motager.composeapp.generated.resources.Password_Is_Empty
import motager.composeapp.generated.resources.Res
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.login.domain.UserDataValidator

fun UserDataValidator.UserDataError.toUiText(): UiText {
    val stringRes = when (this) {
        UserDataValidator.UserDataError.EMAIL_IS_EMPTY -> Res.string.Email_Is_Empty
        UserDataValidator.UserDataError.INVALID_EMAIL -> Res.string.Invalid_Email
        UserDataValidator.UserDataError.PASSWORD_IS_EMPTY -> Res.string.Password_Is_Empty
    }
    return UiText.StringResourceId(stringRes)
}
