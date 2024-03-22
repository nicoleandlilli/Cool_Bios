package com.cash.profin.ya.dinero.plata.lib_net.exception

import kotlin.properties.Delegates

open class BaseException(): Exception() {
    var code: Int = 0
    var displayMsg:String = ""

    init {
        this.code = code
        this.displayMsg = displayMsg
    }
    constructor(code: Int, displayMsg: String) : this(){
        this.code = code
        this.displayMsg = displayMsg
    }

    companion object{

        //  api

        //服务器异常
        const val ERROR_API_SYSTEM:Int = 10000

        //登录错误、用户名密码错误
        const val ERROR_API_LOGIN:Int = 10001

        //调用无权限的API
        const val ERROR_NO_PERMISSION:Int = 10002

        //账户被冻结
        const val ERROR_API_ACCOUNT_FREEZE:Int = 10003
        //API错误
        const val ERROR_API_ERROR:Int = 0x0


        //HTTP
        const val ERROR_HTTP_400:Int = 400
        const val ERROR_HTTP_404:Int = 404
        const val ERROR_HTTP_405:Int = 405
        const val ERROR_HTTP_500:Int = 500

        //网络错误
        const val ERROR_NETWORK:Int = 0X1
        //HTTP错误
        const val ERROR_HTTP:Int = 0X2
        //JSON错误
        const val ERROR_JSON:Int = 0X3
        //未知错误
        const val ERROR_UNKNOWN:Int = 0X4
        //运行时异常-包含自定义异常
        const val ERROR_RUNTIME:Int = 0X5
        //无法解析该域名
        const val ERROR_UNKNOWNHOST:Int = 0X6
        //网络超时
        const val ERROR_SOCKET_TIMEOUT:Int = 0X7
        //无法连接网络
        const val ERROR_SOCKET:Int = 0X8
    }
}