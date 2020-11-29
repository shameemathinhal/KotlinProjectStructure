package com.shameem.projectstructure.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.shameem.projectstructure.data.api.ApiHelper
import com.shameem.projectstructure.utils.Resource
import com.shameem.projectstructure.utils.isConnected
import kotlinx.coroutines.launch

class HomeViewModel(
    private val apiHelper: ApiHelper,
    private val context: Context
) : ViewModel() {

    private val users = MutableLiveData<Resource<List<JsonObject>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromApi = apiHelper.getUsers()
                if (!usersFromApi.isNullOrEmpty()) {
                    users.postValue(Resource.success(usersFromApi))
                } else {
                    users.postValue(Resource.dataEmpty("No Data", null))
                }
            } catch (e: Exception) {
                if (context.isConnected) {
                    users.postValue(Resource.error(e.toString(), null))
                } else {
                    users.postValue(Resource.noInternet(e.toString(), null))
                }

            }
        }
    }

    fun getUsers(): LiveData<Resource<List<JsonObject>>> {
        return users
    }

}