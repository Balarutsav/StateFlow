package com.utsav.stateflowdemo.repository

import com.utsav.stateflowdemo.model.LoginResponse
import com.utsav.stateflowdemo.model.Post
import com.utsav.stateflowdemo.network.ApiServiceImpl
import com.utsav.stateflowdemo.network.BaseDataSource
import com.utsav.stateflowdemo.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl, var baseDataSource: BaseDataSource) {

    fun getPost(): Flow<List<Post>> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)

    fun doLogin(requestMap: Map<String, String>): Flow<Resource<LoginResponse>> = flow {
        var response: Response<LoginResponse> = apiServiceImpl.doLogin(requestMap)
        response.run {
            emit(baseDataSource.getResult { this })
        }
    }.flowOn(Dispatchers.IO)


}