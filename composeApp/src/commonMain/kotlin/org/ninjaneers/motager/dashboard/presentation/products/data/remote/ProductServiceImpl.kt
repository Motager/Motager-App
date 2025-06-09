package org.ninjaneers.motager.dashboard.presentation.products.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.headers
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

class ProductServiceImpl(
    private val client: HttpClient
) : ProductService {
    override suspend fun uploadProductImage(
        image: ByteArray,
        path: String
    ): Result<String, RemoteError> {
        return safeCall<String> {
            client.submitFormWithBinaryData(
                url = "https://rfehfdthjyysdkpzspzl.supabase.co/storage/v1/object/product-images/$path",
                formData = formData {
                    append(
                        key = "file",
                        value = image,
                        headers = Headers.build {
                            append(HttpHeaders.ContentType, "image/jpeg")
                        }
                    )
                }
            ) {
                method = HttpMethod.Post
                headers {
                    append(
                        "apikey",
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJmZWhmZHRoanl5c2RrcHpzcHpsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDkzODY5MzUsImV4cCI6MjA2NDk2MjkzNX0.GxNfNj4uitJU3-UxhZH2LfIguRb5OCe6F0Y6Oall4oQ"
                    )
                    append(
                        HttpHeaders.Authorization,
                        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJmZWhmZHRoanl5c2RrcHpzcHpsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDkzODY5MzUsImV4cCI6MjA2NDk2MjkzNX0.GxNfNj4uitJU3-UxhZH2LfIguRb5OCe6F0Y6Oall4oQ"
                    )
                }
            }
        }
    }
}