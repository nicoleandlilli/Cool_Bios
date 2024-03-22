package com.cash.profin.ya.dinero.plata.lib_net.rx

import io.reactivex.rxjava3.core.FlowableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers


class RxScheduler {

    companion object{
        /**
         * 统一线程处理
         */
        fun<T : Any> io_main(): FlowableTransformer<T,T>{
            return FlowableTransformer{
                it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }
}