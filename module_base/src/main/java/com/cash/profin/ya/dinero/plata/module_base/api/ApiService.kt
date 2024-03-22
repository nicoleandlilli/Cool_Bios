package com.cash.profin.ya.dinero.plata.module_base.api

import com.cash.profin.ya.dinero.plata.module_base.bean.Person
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("api/v7/index/tab/discovery")
    fun getDiscoverData():Flowable<List<Person>>
}