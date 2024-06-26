package com.cash.profin.ya.dinero.plata.module_base.net

import com.cash.profin.ya.dinero.plata.module_base.api.ApiService
import com.cash.profin.ya.dinero.plata.module_base.config.AppConfig
import com.cash.profin.ya.dinero.plata.lib_net.interceptor.CommonParamsInterceptor
import com.cash.profin.ya.dinero.plata.lib_net.interceptor.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

//    val service: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
//        getRetrofit()
//            .create(ApiService::class.java)
//    }

//    var service: ApiService =  getRetrofit().create(ApiService::class.java)
    var service: ApiService? =  null



    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConfig.BASE_SERVER_URL)  //自己配置
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
            .addInterceptor(CommonParamsInterceptor())  //参数添加
            .addInterceptor(HeaderInterceptor()) // token过滤
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

}