package com.cash.profin.ya.dinero.plata.lib_net.bean

import android.util.Log
import com.google.gson.JsonParseException
import org.json.JSONException
import java.io.InterruptedIOException
import java.lang.Exception
import java.net.ConnectException
import java.net.UnknownHostException

object HttpResult {
//    fun <T> create(request:() -> HttpResponse<T>): T?{
//        return try {
//            val response = request.invoke()
//            response.data
//        }catch (e:Exception){
//            if (e is ConnectException) {
////                ToastUtils.showShort("连接服务器失败")
//                Log.e("HttpResult", "create: " + e.message)
//            } else if (e is UnknownHostException) {
////                ToastUtils.showShort("未知服务器异常")
//                Log.e("HttpResult", "create: " + e.message)
//            } else if (e is InterruptedIOException) {
////                ToastUtils.showShort("连接服务器超时")
//                Log.e("HttpResult", "create: " + e.message)
////            } else if (e is JSONException || e is JsonParseException || e is ParseException) {
//            } else if (e is JSONException || e is JsonParseException) {
////                ToastUtils.showShort("数据解析出错")
//                Log.e("HttpResult", "create: " + e.message)
//            } else {
////                ToastUtils.showShort("未知的网络错误")
//                Log.e("HttpResult", "create: " + e.message)
//            }
//            Log.e("HttpResult", "create: " + e.message)
//            null
//        }
//    }
}