package com.cash.profin.ya.dinero.plata.module_main.ui

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseActivity
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainEditMessageBinding
import com.google.firebase.firestore.FirebaseFirestore

@Route(path = RouterPaths.EDIT_ACTIVITY)
class EditActivity:BaseActivity<MainEditMessageBinding>() {

    var ids = ArrayList<String>()
    override fun initData() {

        mBinding.ivBack.setOnClickListener({
            finish()
        })


        var extrsa = intent.extras
        var document_id: String? = extrsa?.getString("document_id")
//        document_id?.let {
//            addEdiText(document_id,this,mBinding.lvContent)
//        }

        var name: String? = extrsa?.getString("name")
        name?.let {
            ids.add("name")
            addEdiText(name,this,mBinding.lvContent)
        }

        var gender: String? = extrsa?.getString("gender")
        gender?.let {
            ids.add("gender")
            addEdiText(gender,this,mBinding.lvContent)
        }

        var age: Long? = extrsa?.getLong("age")
        age?.let {
            ids.add("age")
            addEdiText("$age",this,mBinding.lvContent)
        }

        var hobby: String? = extrsa?.getString("hobby")
        hobby?.let {
            ids.add("hobby")
            addEdiText(hobby,this,mBinding.lvContent)
        }



        mBinding.tvSave.setOnClickListener {

            Thread {
                val db: FirebaseFirestore = FirebaseFirestore.getInstance()
                if (document_id != null) {
                    var ref = db.collection("message").document(document_id)
                    var hashMap: HashMap<String, Any> = hashMapOf()

                    for (i in 0 until mBinding.lvContent.getChildCount() - 1) {
                        val view: View = mBinding.lvContent.getChildAt(i)
                        if (view is EditText) {
                            val editText = view as EditText
                            val content = editText.text.toString()
                            if(ids.get(i).equals("age")){
                                var ageValue = content.toLong()
                                hashMap[ids.get(i)] = ageValue
                            }else{
                                hashMap[ids.get(i)] = content.trim()
                            }


                        }
                    }

                    ref.update(hashMap)

                }
            }.start()

            Toast.makeText(this, "Saved........", Toast.LENGTH_SHORT).show()

        }

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