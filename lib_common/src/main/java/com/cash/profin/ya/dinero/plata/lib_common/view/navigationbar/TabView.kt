package com.cash.profin.ya.dinero.plata.lib_common.view.navigationbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.cash.profin.ya.dinero.plata.lib_common.databinding.ViewTabBinding

class TabView : LinearLayout {
    private lateinit var mBinding: ViewTabBinding
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        orientation = VERTICAL
        init(context)
    }

    fun init(context: Context) {
        mBinding = ViewTabBinding.inflate(LayoutInflater.from(context),this,true)
    }

    fun setTabData(tabData: TabData) {
        mBinding.image.setBackgroundResource(tabData.icon)
        mBinding.text.text = tabData.text
        isSelected = tabData.isSelected
    }
}