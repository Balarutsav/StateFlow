package com.utsav.stateflowdemo.network

import com.utsav.stateflowdemo.model.LoginResponse
import com.utsav.stateflowdemo.model.Post
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts")
   suspend fun getPost():List<Post>

    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(@FieldMap paramLogin: Map<String, String>): Response<LoginResponse>
}