package com.cash.profin.ya.dinero.plata.module_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cash.profin.ya.dinero.plata.module_home.R
import com.cash.profin.ya.dinero.plata.module_home.bean.Article
import com.cash.profin.ya.dinero.plata.module_home.databinding.HomePopularItemBinding
import com.cash.profin.ya.dinero.plata.module_home.databinding.MainNewsItemBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot


class NewsTopHeadLineAdapter():
    RecyclerView.Adapter<NewsTopHeadLineAdapter.ArticleViewHolder>(){

    var mDocumentSnapshots : List<DocumentSnapshot> = ArrayList<DocumentSnapshot>()

    fun setArticleList(documentSnapshots : List<DocumentSnapshot>){
        this.mDocumentSnapshots = documentSnapshots
        notifyDataSetChanged()
    }
    inner class ArticleViewHolder(val binding: HomePopularItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomePopularItemBinding.inflate(inflater,parent,false)
        return  ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
//        return mArticleList.size
        return mDocumentSnapshots.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        var documentSnapshots : List<DocumentSnapshot>
        var documentSnapshot:DocumentSnapshot = mDocumentSnapshots.get(position)

        documentSnapshot?.let {
//            holder.binding.tvContent.text = article.title
            holder.binding.tvContent.setText(documentSnapshot.data.toString())
        }

    }

}