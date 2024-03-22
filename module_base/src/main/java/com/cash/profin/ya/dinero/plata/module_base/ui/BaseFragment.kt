package com.cash.profin.ya.dinero.plata.module_base.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T:ViewBinding>:Fragment() {

    protected open lateinit var mBinding: T

    private var rootView : View? = null
    protected var mContext : Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is Activity)
            mContext = context
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = getViewBinding(container)
        if(rootView == null)
            rootView = mBinding.root

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    abstract fun getViewBinding(container: ViewGroup?): T

    abstract fun initView()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
    }
}