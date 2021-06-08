package com.example.desafiodb.model

import com.google.gson.annotations.SerializedName

class InstallmentDetail(
    @SerializedName("overdue_days") val overdueDays: String,
    @SerializedName("overdue_date") val overdueDate: String,
    @SerializedName("original_value") val originalValue: String,
    @SerializedName("value_diff") val valueDiff: String,
    @SerializedName("total_value") val totalValue: String,
    @SerializedName("store") val store: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("images") val images: List<String>,
)