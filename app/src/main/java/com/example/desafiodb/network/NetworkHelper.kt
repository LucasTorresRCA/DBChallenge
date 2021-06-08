package com.example.desafiodb.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

object NetworkHelper {
    private val retrofit: Retrofit by lazy {
        return@lazy Retrofit.Builder()
            .baseUrl("https://www.icoded.com.br/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    private val client: OkHttpClient by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return@lazy OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    fun <T>create(kClass: KClass<*>): T {
        return retrofit.create(kClass.java) as T
    }
}