package com.cash.profin.ya.dinero.plata.module_main.ui

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseActivity
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainEditMessageBinding
import com.cash.profin.ya.dinero.plata.module_main.ui.dialog.CustomGenderDialog
@Route(path = RouterPaths.EDIT_ACTIVITY)
class EditActivity:BaseActivity<MainEditMessageBinding>() {


    override fun initData() {

        mBinding.ivBack.setOnClickListener({
            finish()
        })



        var extrsa = intent.extras
        var name: String? = extrsa?.getString("name")
        name?.let {
            addEdiText(name,this,mBinding.lvContent)
        }

        var gender: String? = extrsa?.getString("gender")
        gender?.let {
            addEdiText(gender,this,mBinding.lvContent)
        }

        var age: Long? = extrsa?.getLong("age")
        age?.let {
            addEdiText("$age",this,mBinding.lvContent)
        }

        var hobby: String? = extrsa?.getString("hobby")
        hobby?.let {
            addEdiText(hobby,this,mBinding.lvContent)
        }

        Log.d("HomeFragment","received ............name= $name   ........age = $age  .......$gender .......$hobby")


        mBinding.tvSave.setOnClickListener({

        })

    }

    override fun initView() {


    }


    override fun getViewBinding() = MainEditMessageBinding.inflate(layoutInflater)


    fun addEdiText(content: String, context: Context, linearLayout: ViewGroup){
        var editText = EditText(context)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

//        layoutParams.setMargins(16,16,16,16)

        editText.background = null
        editText.setTextSize(18F)
        editText.setTextColor(Color.BLACK)
        editText.setText(content)

//        linearLayout.addView(editText,layoutParams)
        linearLayout.addView(editText)
    }

    private fun refreshView(){
        recreate()
    }


}