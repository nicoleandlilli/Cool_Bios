package com.cash.profin.ya.dinero.plata.lib_net.exception

class ApiException() : BaseException() {
    constructor(code: Int, displayMsg: String) : this(){
        this.code = code
        this.displayMsg = displayMsg
    }
}