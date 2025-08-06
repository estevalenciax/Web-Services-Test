package com.ev.myapplication.repository

import com.ev.myapplication.model.respose.Category

interface Repository {

    suspend fun getCategories(): List<String>

    suspend fun getCategoriesDetails(categorie: String): Category
}