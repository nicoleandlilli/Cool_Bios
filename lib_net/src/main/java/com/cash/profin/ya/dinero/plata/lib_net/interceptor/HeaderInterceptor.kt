package com.cash.profin.ya.dinero.plata.lib_net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

            .header("thatBurialRapidBeautyRecentChoice", "267")
            .header("energeticNightLesson", "googleplay")
            .header("arabInternationalTomorrow", "1.0.0")
            .header("extraLoudSoupIndianToday", "1")
            .header("gratefulAgreement", "1")
            .header("tiresomeCrowdedSheepBasicRest", "device-id")//device-id
            .header("mainAsh", "imei")//imei


            .method(originalRequest.method, originalRequest.body)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}