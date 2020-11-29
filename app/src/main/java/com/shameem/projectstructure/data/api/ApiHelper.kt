package com.shameem.projectstructure.data.api

import com.google.gson.JsonObject


interface ApiHelper {

    suspend fun getUsers(): List<JsonObject>
}