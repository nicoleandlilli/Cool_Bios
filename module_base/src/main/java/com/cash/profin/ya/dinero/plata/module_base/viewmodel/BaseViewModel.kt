package com.cash.profin.ya.dinero.plata.module_base.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel

open class BaseViewModel(): ViewModel() {

    lateinit var mContext: Context

    fun setContext(context: Context) {
        this.mContext = context
    }
}