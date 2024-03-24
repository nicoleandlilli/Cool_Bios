package com.cash.profin.ya.dinero.plata.module_home.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_credit.databinding.HomeLatestItemBinding
import com.google.firebase.firestore.DocumentSnapshot


class LatestMessageAdapter():
    RecyclerView.Adapter<LatestMessageAdapter.ArticleViewHolder>(){

    var mDocumentSnapshots : ArrayList<DocumentSnapshot> = ArrayList<DocumentSnapshot>()

    fun setArticleList(documentSnapshots : ArrayList<DocumentSnapshot>){
        mDocumentSnapshots.clear()
        this.mDocumentSnapshots = documentSnapshots
        notifyDataSetChanged()
    }
    inner class ArticleViewHolder(val binding: HomeLatestItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeLatestItemBinding.inflate(inflater,parent,false)
        return  ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mDocumentSnapshots.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        var documentSnapshot:DocumentSnapshot = mDocumentSnapshots.get(position)

        Log.d("HomeFragment", documentSnapshot.id + " => " + documentSnapshot.data)

        var context = holder.binding.lvContent.context

        var linearLayout = holder.binding.lvContent
        linearLayout.removeAllViews()

        var name:String = documentSnapshot["name"].toString();
        Log.d("HomeFragment", "name  => " + name)
        name?.let {
            addEdiText(name,context,linearLayout)
        }

        var gender:String = documentSnapshot["gender"].toString();
        Log.d("HomeFragment", "gender  => " + gender)
        gender?.let {
            addEdiText(gender,context,linearLayout)
        }


        var age:Long = documentSnapshot["age"] as Long;
        Log.d("HomeFragment", "age  => " + age)
        age?.let {
            addEdiText("$age",context,linearLayout)
        }

        var hobby:String = documentSnapshot["hobby"].toString();
        Log.d("HomeFragment", "hobby  => " + hobby)
        hobby?.let {
            addEdiText(hobby,context,linearLayout)
        }

        var favarite_number:Long = documentSnapshot["favarite_number"] as Long
        holder.binding.tvFavoriteNumber.text = "$favarite_number"

        holder.binding.ivEdit.setOnClickListener({
            ARouter.getInstance()
                .build(RouterPaths.EDIT_ACTIVITY)
                .withString("name",name)
                .withString("gender",gender)
                .withLong("age",age)
                .withString("hobby",hobby)
                .navigation()
        })

    }

    fun addEdiText(content: String,context: Context,linearLayout: ViewGroup){
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

}