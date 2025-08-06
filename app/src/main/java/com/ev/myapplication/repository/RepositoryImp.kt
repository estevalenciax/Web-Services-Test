package com.ev.myapplication.repository

import com.ev.myapplication.core.network.RetrofitHelper.getRetrofit
import com.ev.myapplication.core.network.WebService
import com.ev.myapplication.model.respose.Category


class RepositoryImp(@Inject contructor val webService: WebService) : Repository {

    override suspend fun getCategories(): List<String> {
        try {
            val webService = getRetrofit().create(WebService::class.java)
            val response = webService.getCategories()
            return response
        } catch (e: Exception) {
            return emptyList()
        }
    }

    override suspend fun getCategoriesDetails(categorie: String): Category {
        try {
            val webService = getRetrofit().create(WebService::class.java)
            val response = webService.getCategoryDetails(categorie)

            return Category(
                categories = response.categories,
                response.createdAt,
                response.iconUrl,
                response.id,
                response.updateAt,
                response.url,
                response.value
            )
        } catch (e: Exception) {
            return Category()
        }
    }
}