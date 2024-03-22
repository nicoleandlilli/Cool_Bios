package com.cash.profin.ya.dinero.plata.lib_net.rx

import android.content.Context
import android.widget.Toast
import com.cash.profin.ya.dinero.plata.lib_net.exception.ApiException
import com.cash.profin.ya.dinero.plata.lib_net.exception.BaseException
import com.cash.profin.ya.dinero.plata.lib_net.exception.ErrorMessageFactory
import com.cash.profin.ya.dinero.plata.module_base.view.CustomTimeOutDialog
import java.net.SocketException
import java.net.SocketTimeoutException

class RxErrorHandler {

    lateinit var context: Context

    constructor(context: Context){
        this.context = context
    }

    fun handleError(e:Throwable):BaseException{
        var exception = ApiException()

        if(e is ApiException){
            exception.code = e.code
        }else if(e is SocketException){
            exception.code = BaseException.ERROR_SOCKET
        }else if(e is SocketTimeoutException){
            exception.code = BaseException.ERROR_SOCKET_TIMEOUT
        }
//        else if(e is HttpException){
//            exception.code = BaseException.ERROR_HTTP
//        }
        else{
            exception.code = BaseException.ERROR_UNKNOWN
        }

        exception.displayMsg = ErrorMessageFactory.create(context,exception.code)

        return exception
    }

    fun showMessage(exception: BaseException){
        Toast.makeText(context,exception.displayMsg,Toast.LENGTH_SHORT).show()
    }


    fun showNetDialog(){
        var dialog = CustomTimeOutDialog(context)
        dialog?.apply {
            btCancel.setOnClickListener() {
                dismiss()
            }

            btConfirm.setOnClickListener {
                dismiss()
            }
            show()
        }

    }
}