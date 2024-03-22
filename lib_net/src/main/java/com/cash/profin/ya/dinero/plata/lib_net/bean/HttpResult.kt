package com.cash.profin.ya.dinero.plata.lib_net.bean

data class HttpResult<T> (var errorCode: Int, var errorMessage:String, var data: T)
