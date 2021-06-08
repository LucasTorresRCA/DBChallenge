package com.example.desafiodb.model

import com.google.gson.annotations.SerializedName

class Installment(
    @SerializedName("past_due") val pastDue: String,
    @SerializedName("carnet") val carnet: String,
    @SerializedName("installment") val installment: String,
    @SerializedName("value") val value: String,
    @SerializedName("detail") val detail: InstallmentDetail,
)