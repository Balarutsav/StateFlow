package com.utsav.stateflowdemo.di

import com.utsav.stateflowdemo.BuildConfig
import com.utsav.stateflowdemo.network.ApiService
import com.utsav.stateflowdemo.network.BaseDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesUrl() = "http://3.20.187.116/api/driver_api/"

    @Provides
    @Singleton
    fun providesApiService(url:String,okHttpClient: OkHttpClient) : ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    @Provides
    fun okHttpClient(): OkHttpClient {
        val levelType: HttpLoggingInterceptor.Level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original: Request = chain.request()

                // Request customization: add request headers

                val requestBuilder = original.newBuilder()
                    .header("key", "Cluttr951*#*") // <-- this is the important line

                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        })
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.addNetworkInterceptor(logging)

        val client = httpClient.build()
        return client

    }
    @Provides
    @Singleton
    fun getBaseResponse(): BaseDataSource {
        return BaseDataSource();
    }
}