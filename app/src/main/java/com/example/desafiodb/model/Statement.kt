package com.example.desafiodb.model

import com.google.gson.annotations.SerializedName

class Statement(
    @SerializedName("name") val name: String,
    @SerializedName("total_overdue") val totalOverdue: String,
    @SerializedName("total_due") val totalDue: String,
    @SerializedName("installments") val installments: List<Installment>,
    @SerializedName("limits") val limits: Limit?,
)