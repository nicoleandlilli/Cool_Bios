package com.cash.profin.ya.dinero.plata.module_base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T:ViewBinding>:AppCompatActivity(){

    protected open lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getViewBinding()
        setContentView(mBinding.root)
        initView()
        initData()
    }

    abstract fun getViewBinding(): T

    abstract fun initData()

    abstract fun initView()
}