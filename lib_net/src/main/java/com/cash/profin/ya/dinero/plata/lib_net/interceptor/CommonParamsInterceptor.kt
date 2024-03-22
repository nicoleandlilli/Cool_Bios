package com.cash.profin.ya.dinero.plata.lib_net.interceptor


import com.cash.profin.ya.dinero.plata.lib_common.CommonApplication
import com.cash.profin.ya.dinero.plata.lib_common.utils.DeviceUtil
import com.cash.profin.ya.dinero.plata.lib_common.utils.DisplayUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CommonParamsInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        var request: Request
        val modifiedUrl = originalRequest.url.newBuilder()
            .addQueryParameter("simpleMostGarbageCountry", "267")
            .addQueryParameter("freshExhibitionLovelyCowboyBoundTeacher", "0.0")
            .addQueryParameter("fastLittleFeatherThing", "es")
            .build()

        request = originalRequest.newBuilder().url(modifiedUrl).build()
        return chain.proceed(request)
    }
}