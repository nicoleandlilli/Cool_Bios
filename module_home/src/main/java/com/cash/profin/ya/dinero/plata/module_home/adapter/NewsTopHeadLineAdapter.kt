package com.cash.profin.ya.dinero.plata.module_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cash.profin.ya.dinero.plata.module_home.R
import com.cash.profin.ya.dinero.plata.module_home.bean.Article
import com.cash.profin.ya.dinero.plata.module_home.databinding.HomePopularItemBinding
import com.cash.profin.ya.dinero.plata.module_home.databinding.MainNewsItemBinding


class NewsTopHeadLineAdapter():
    RecyclerView.Adapter<NewsTopHeadLineAdapter.ArticleViewHolder>(){

    private var mArticleList = ArrayList<Article>()

    fun setArticleList(articleList:List<Article>){
        this.mArticleList = articleList as ArrayList<Article>
        notifyDataSetChanged()
    }
    inner class ArticleViewHolder(private val binding: HomePopularItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
//        return ArticleViewHolder(
//            HomePopularItemBinding.inflate(
//                LayoutInflater.from(parent.context)
//            )
//        )

        val inflater = LayoutInflater.from(parent.context)
        val binding = HomePopularItemBinding.inflate(inflater,parent,false)
        return  ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mArticleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        var article: Article? = mArticleList.get(position)

        article?.let {
//            holder.binding.tvContent.text = article.title
//            holder.binding.tvContent.setText(article?.title);
        }

    }

}