package com.cash.profin.ya.dinero.plata.lib_net.rx.subscriber


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.cash.profin.ya.dinero.plata.lib_net.exception.BaseException
import com.cash.profin.ya.dinero.plata.lib_net.rx.RxErrorHandler


abstract class ErrorHandlerSubscriber<T : Any>: BaseSubscriber<T> {

    private var mRxErrorHandler: RxErrorHandler

    constructor(rxErrorHandler: RxErrorHandler){
        this.mRxErrorHandler = rxErrorHandler
    }

    override fun onError(e: Throwable?) {
        Log.d("TEST", e.toString())
        if (e != null) {
            var exception = mRxErrorHandler.handleError(e)
            mRxErrorHandler.showMessage(exception)

            when(exception.code){
                BaseException.ERROR_SOCKET_TIMEOUT ->
                    mRxErrorHandler.showNetDialog()
            }
        }
    }
}