package com.cash.profin.ya.dinero.plata.module_base.ui

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.cash.profin.ya.dinero.plata.module_base.R


abstract class BaseActivity<T:ViewBinding>:AppCompatActivity(){
    protected open lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getViewBinding()
        setContentView(mBinding.root)
        setStateBar()
        initView()
        initData()
    }

    abstract fun getViewBinding(): T

    abstract fun initData()

    abstract fun initView()

    fun setStateBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 对于Android 5.0及以上版本
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = getResources().getColor(R.color.pink)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 对于Android 4.4到5.0版本
            // 这里可以通过修改系统资源来改变状态栏颜色，但这种方式较为复杂且有局限性
        }
    }
}