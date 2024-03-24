package com.cash.profin.ya.dinero.plata.module_main.ui

import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseActivity
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainEditMessageBinding
import com.cash.profin.ya.dinero.plata.module_main.ui.dialog.CustomGenderDialog
@Route(path = RouterPaths.EDIT_ACTIVITY)
class EditActivity:BaseActivity<MainEditMessageBinding>() {

//    @Autowired
//    var name:String = ""
//
//    @Autowired
//    lateinit var gender:String
//
//    @Autowired
//    var age:Long = 1L
//
//    @Autowired
//    lateinit var hobby:String

    override fun initData() {

        var extrsa = intent.extras
        var name: String? = extrsa?.getString("name")
        var gender: String? = extrsa?.getString("gender")
        var age: Long? = extrsa?.getLong("age")
        var hobby: String? = extrsa?.getString("hobby")
        Log.d("HomeFragment","received ............name= $name   ........age = $age  .......$gender .......$hobby")
    }

    override fun initView() {


    }


    override fun getViewBinding() = MainEditMessageBinding.inflate(layoutInflater)



    private fun refreshView(){
        recreate()
    }


}