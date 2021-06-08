package com.example.desafiodb.model

import com.google.gson.annotations.SerializedName

class ResponseWrapper<T>(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data")val data: T
)