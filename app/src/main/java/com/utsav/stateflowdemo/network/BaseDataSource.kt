package com.utsav.stateflowdemo.network

import com.utsav.stateflowdemo.model.BaseResponse
import retrofit2.Response


 open class BaseDataSource {

    open suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if(response.code()==403){
                return Resource.error("",code = response.code())
            }else if (response.body()!=null) {
                val baseResponse= (response.body() as BaseResponse)
                if (response.isSuccessful&&baseResponse.status) {
                    response.body()?.let {
                        return Resource.success(it,baseResponse.message);
                    }
                } else {
                    val body = response.body()
                    if (body != null) {
                        return Resource.error(baseResponse.message)
                    }
                }
                return error("Success => ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            return error("Error => ${e.message} ?: ${e.toString()}")
        }
        return Resource.error("")
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error(message)
    }
}