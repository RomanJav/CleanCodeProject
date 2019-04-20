package by.tomal.data.net

import by.tomal.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object VehicleHttpClientBuilder {

    fun getHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        clientBuilder.connectTimeout(5, TimeUnit.SECONDS)
        return clientBuilder.build()
    }
}