package com.shameem.projectstructure.data.api

import com.google.gson.JsonObject
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<JsonObject>



}