package com.ev.myapplication.model.respose

import com.google.gson.annotations.SerializedName

data class Category(
    val categories: List<String> = listOf(),
    val createdAt: String = "",
    val iconUrl: String = "",
    val id: String = "",
    val updateAt: String = "",
    val url: String = "",
    val value: String = "",
)
