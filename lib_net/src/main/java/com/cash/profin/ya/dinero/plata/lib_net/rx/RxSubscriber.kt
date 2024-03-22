package com.cash.profin.ya.dinero.plata.lib_net.rx

import io.reactivex.rxjava3.subscribers.ResourceSubscriber

class RxSubscriber<T>(): ResourceSubscriber<T>() {

    override fun onNext(t: T) {

    }

    override fun onError(t: Throwable?) {

    }

    override fun onComplete() {

    }
}