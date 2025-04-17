package org.ninjaneers.motager.core.domain

enum class RemoteError : Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER,
    SERIALIZATION,
    UNAUTHORIZED,
    UNKNOWN
}