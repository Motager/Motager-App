package org.ninjaneers.motager.core.data.network


import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import okio.IOException
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, RemoteError> {
    val response = try {
        execute()
    } catch (e: SocketTimeoutException) {
        return Result.Error(RemoteError.REQUEST_TIMEOUT)
    } catch (e: IOException) {
        return Result.Error(RemoteError.NO_INTERNET)
    } catch (e: UnresolvedAddressException) {
        return Result.Error(RemoteError.NO_INTERNET)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(RemoteError.UNKNOWN)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, RemoteError> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(RemoteError.SERIALIZATION)
            }
        }

        408 -> Result.Error(RemoteError.REQUEST_TIMEOUT)
        429 -> Result.Error(RemoteError.TOO_MANY_REQUESTS)
        401 -> Result.Error(RemoteError.UNAUTHORIZED)
        in 500..599 -> Result.Error(RemoteError.SERVER)
        else -> Result.Error(RemoteError.UNKNOWN)
    }
}