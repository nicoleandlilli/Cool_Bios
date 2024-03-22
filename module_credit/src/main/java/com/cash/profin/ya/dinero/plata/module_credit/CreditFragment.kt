package com.cash.profin.ya.dinero.plata.module_credit


import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_credit.databinding.CreditFragmentCreditBinding
@Route(path = RouterPaths.CREDIT_FRAGMENT)
class CreditFragment:BaseFragment<CreditFragmentCreditBinding>() {
    override fun getViewBinding(container: ViewGroup?)=CreditFragmentCreditBinding.inflate(layoutInflater)

    override fun initView() {

    }

    override fun initData() {

    }
}