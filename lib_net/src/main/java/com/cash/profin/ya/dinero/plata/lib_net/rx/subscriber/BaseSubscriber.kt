package com.cash.profin.ya.dinero.plata.lib_net.rx.subscriber

import io.reactivex.rxjava3.core.FlowableSubscriber

abstract class BaseSubscriber<T : Any>: FlowableSubscriber<T> {
    constructor()
}