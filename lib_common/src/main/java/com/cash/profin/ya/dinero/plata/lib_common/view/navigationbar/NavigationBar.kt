package com.cash.profin.ya.dinero.plata.lib_common.view.navigationbar

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cash.profin.ya.dinero.plata.lib_common.R

class NavigationBar : LinearLayout{
    private val tabImages = arrayOf(
//        com.google.android.material.R.drawable.ic_arrow_back_black_24,
//        com.google.android.material.R.drawable.abc_ab_share_pack_mtrl_alpha,

        R.drawable.tabview_line,
        R.drawable.tabview_line,

    )

    private val tabText = arrayOf("Popular", "Latest")

    private val tabViews: MutableList<TabView>? = mutableListOf()
    private val tabDatas: MutableList<TabData>? = mutableListOf()

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        init(context)
    }

    private fun init(context: Context) {
        for (index in tabImages.indices) {
            val tabData = TabData(
                tabImages[index],
                tabText[index],
                index == 0
            )
            val tabView = TabView(context)

            tabView.setOnClickListener {
                val childIndex = indexOfChild(tabView)
                if (tabDatas?.get(childIndex)?.isSelected!!) {
                    onViewClickListener?.onReSelected(childIndex)
                }
                setCurrentIndex(childIndex)
                onViewClickListener?.onSelected(childIndex)
            }

            tabView.setTabData(tabData)
            tabView.gravity = Gravity.CENTER
            tabViews?.add(tabView)
            tabDatas?.add(tabData)

            val layoutParams = LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutParams.width = 0
            layoutParams.weight = 1.0f
            addView(tabView, layoutParams)
        }
    }

    /**
     *  选中指定tab
     */
    fun setCurrentIndex(position: Int) {
        for (index in tabViews!!.indices) {
            val tabView = tabViews[index]
            val tabData = tabDatas?.get(index)
            tabData?.isSelected = index == position
            tabView.setTabData(tabData!!)
        }
    }


    private var onViewClickListener: OnViewClickListener? = null

    interface OnViewClickListener {

        fun onSelected(position: Int)

        fun onReSelected(position: Int)
    }

    fun setOnViewClickListener(onViewClickListener: OnViewClickListener) {
        this.onViewClickListener = onViewClickListener
    }
}