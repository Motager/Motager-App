package org.ninjaneers.motager.core.presentation

import motager.composeapp.generated.resources.Error_no_internet
import motager.composeapp.generated.resources.Error_request_timeout
import motager.composeapp.generated.resources.Error_serialization
import motager.composeapp.generated.resources.Error_too_many_requests
import motager.composeapp.generated.resources.Error_unauthorized
import motager.composeapp.generated.resources.Error_unknown
import motager.composeapp.generated.resources.Res
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.UiText


fun RemoteError.toUiText(): UiText {
    val stringRes = when (this) {
        RemoteError.REQUEST_TIMEOUT -> Res.string.Error_request_timeout
        RemoteError.TOO_MANY_REQUESTS -> Res.string.Error_too_many_requests
        RemoteError.NO_INTERNET -> Res.string.Error_no_internet
        RemoteError.SERVER -> Res.string.Error_unknown
        RemoteError.SERIALIZATION -> Res.string.Error_serialization
        RemoteError.UNKNOWN -> Res.string.Error_unknown
        RemoteError.UNAUTHORIZED -> Res.string.Error_unauthorized
    }

    return UiText.StringResourceId(stringRes)
}