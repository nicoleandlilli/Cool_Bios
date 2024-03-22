package com.cash.profin.ya.dinero.plata.lib_net.exception

import android.content.Context
import android.net.http.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException

object ErrorMessageFactory {

    fun create(context: Context,code:Int):String{
        var  errorMsg = ""
        when(code){
//            BaseException.ERROR_HTTP ->{
////                errorMsg = context.resources.getString(R.string.error_http)
//                errorMsg = "Http 错误"
//            }
            BaseException.ERROR_API_ERROR ->{
                errorMsg = "Api 错误"
            }
            BaseException.ERROR_SOCKET ->{
                errorMsg = "Socket 错误"
            }
            BaseException.ERROR_SOCKET_TIMEOUT ->{
                errorMsg = "网络请求超时"
            }
//            BaseException.ERROR_HTTP ->{
//                errorMsg = "Http 错误"
//            }

            else ->{//BaseException.ERROR_UNKNOWN
                errorMsg = "未知 错误"
            }
        }
        return errorMsg
    }

}