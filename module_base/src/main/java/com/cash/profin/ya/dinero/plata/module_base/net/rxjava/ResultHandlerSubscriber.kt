package com.cash.profin.ya.dinero.plata.module_base.net.rxjava


import com.cash.profin.ya.dinero.plata.lib_net.rx.RxErrorHandler
import com.cash.profin.ya.dinero.plata.lib_net.rx.subscriber.ErrorHandlerSubscriber
import org.reactivestreams.Subscription


abstract class ResultHandlerSubscriber<T : Any>(rxErrorHandler: RxErrorHandler) :
    ErrorHandlerSubscriber<T>(rxErrorHandler) {

    private lateinit var subscription:Subscription

    override fun onSubscribe(s: Subscription) {
        subscription = s
        subscription.request(Integer.MAX_VALUE.toLong())
    }

    override fun onComplete() {

    }
}