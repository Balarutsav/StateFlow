package com.utsav.stateflowdemo.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.utsav.stateflowdemo.model.LoginRequest
import com.utsav.stateflowdemo.model.LoginResponse
import com.utsav.stateflowdemo.network.Resource
import com.utsav.stateflowdemo.repository.MainRepository
import com.utsav.stateflowdemo.util.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel
@Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {
    private var gson: Gson? = null
    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    private val postLoginFlow: MutableStateFlow<Resource<LoginResponse>> =
        MutableStateFlow(Resource.loading())


    val _postStateFlow: StateFlow<ApiState> = postStateFlow
    val _loginStateFlow: StateFlow<Resource<LoginResponse>> = postLoginFlow

    fun getPost() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.getPost()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data)
            }
    }

    fun doLogin() = viewModelScope.launch {
        postLoginFlow.value = Resource.loading()
        var loginReq = LoginRequest(
            "utsav.balar@excellentwebworld.in",
            "12345678",
            "android",
            "demoadsfasfads ds",
            "12.45",
            "12.45"  /*    location.latitude.toString(),
               location.longitude.toString()
              */
        )
        mainRepository.doLogin(getStringFromObject(loginReq))
            .catch { e ->
                postLoginFlow.value = Resource.error(e.localizedMessage)
            }.collect { data ->
                Log.e("status v",data.status.toString())
                data.message?.let { Log.e("message v", it) }
                postLoginFlow.value = data
            }
    }

    protected open fun <T> getStringFromObject(requestObject: T): Map<String, String> {
        gson = Gson()
        val jsonString: String = gson!!.toJson(requestObject)
        val mapType = object : TypeToken<Map<String?, String?>?>() {}.type
        return gson!!.fromJson(jsonString, mapType)
    }
}