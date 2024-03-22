package com.cash.profin.ya.dinero.plata.lib_net.rx

import com.cash.profin.ya.dinero.plata.lib_net.bean.HttpResponse
import com.cash.profin.ya.dinero.plata.lib_net.exception.ApiException
import com.cash.profin.ya.dinero.plata.lib_net.exception.BaseException
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.FlowableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers
import org.reactivestreams.Publisher

object RxHelper {
    /**
     * 统一处理Flowable
     */
    fun <T : Any> handleResult():FlowableTransformer<HttpResponse<T>,T>{

        return FlowableTransformer{  it->

            it.flatMap { t ->
                if(t.badMountainousQueen == 1000){
                    t?.theoreticalFrench?.let { createData(it) }!!
                }else{
                    t?.theoreticalFrench?.let { createError(ApiException(t.badMountainousQueen,t.manyDueHourRepairs)) }!!
                }
            }
        }

    }

    private fun<T : Any> createData(t:T): Publisher<T>{
        return Flowable.create({ emitter->
            try {
                emitter.onNext(t)
                emitter.onComplete()
            }catch (e:java.lang.Exception){
                emitter.onError(e)
            }
        },BackpressureStrategy.BUFFER)
    }

    private fun<T : Any> createError(t:Throwable): Publisher<T>{
        return Flowable.create({ emitter->
            try {
                emitter.onError(t)
            }catch (e:java.lang.Exception){
                emitter.onError(e)
            }
        },BackpressureStrategy.BUFFER)
    }
}