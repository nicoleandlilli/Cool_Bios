package com.cash.profin.ya.dinero.plata.lib_net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("model", "android")
            .method(originalRequest.method, originalRequest.body)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}