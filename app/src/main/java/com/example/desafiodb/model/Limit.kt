package com.example.desafiodb.model

import com.google.gson.annotations.SerializedName

class Limit(
    @SerializedName("total_due") val totalDue: String,
    @SerializedName("total") val total: String,
    @SerializedName("expent") val expent: String,
    @SerializedName("available") val available: String,
)