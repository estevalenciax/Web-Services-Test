package com.ev.myapplication.model.respose

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    val categories: List<String>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    val id: String,
    @SerializedName("updated_at")
    val updateAt: String,
    val url: String,
    val value: String

)
