package com.utsav.stateflowdemo.network

import com.utsav.stateflowdemo.model.LoginResponse
import com.utsav.stateflowdemo.model.Post
import retrofit2.Response
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost():List<Post> = apiService.getPost()
    suspend fun doLogin(map:Map<String,String>): Response<LoginResponse> = apiService.loginUser(map)
}