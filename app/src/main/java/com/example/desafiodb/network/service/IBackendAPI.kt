package com.example.desafiodb.network.service

import com.example.desafiodb.model.Login
import com.example.desafiodb.model.ResponseWrapper
import com.example.desafiodb.model.Statement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IBackendAPI {
    @POST("login.php")
    fun postLogin(
        @Query("usr") user: String,
        @Query("pwd") password: String
    ): Call<ResponseWrapper<Login>>

    @GET("extract.php")
    fun getStatement(
        @Query("token") token: String,
    ): Call<ResponseWrapper<Statement>>
}