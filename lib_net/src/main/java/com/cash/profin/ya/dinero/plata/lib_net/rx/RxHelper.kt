package com.cash.profin.ya.dinero.plata.lib_net.rx

import com.cash.profin.ya.dinero.plata.lib_net.bean.HttpResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.FlowableTransformer
import org.reactivestreams.Publisher

class RxHelper {
    /**
     * 统一处理Flowable
     */
    fun <T : Any> handleResult():FlowableTransformer<HttpResult<T>,T>{

        return FlowableTransformer{  it->
            it.flatMap({  t->
                t?.data?.let { createData(it) }!!
            })
        }

    }

    private fun<T : Any> createData(t:T): Publisher<T>{
        return Flowable.create({ emitter->
            try {
                emitter.onNext(t)
                emitter.onComplete()
            }catch (e:java.lang.Exception){
                emitter.onComplete()
            }
        },BackpressureStrategy.BUFFER)
    }
}