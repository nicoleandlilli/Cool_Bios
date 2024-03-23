package com.cash.profin.ya.dinero.plata.module_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cash.profin.ya.dinero.plata.module_home.bean.Article
import com.cash.profin.ya.dinero.plata.module_home.databinding.MainNewsItemBinding


class NewsTopHeadLineAdapter():
    RecyclerView.Adapter<NewsTopHeadLineAdapter.ArticleViewHolder>(){

    private var mArticleList = ArrayList<Article>()

    fun setArticleList(articleList:List<Article>){
        this.mArticleList = articleList as ArrayList<Article>
        notifyDataSetChanged()
    }
    inner class ArticleViewHolder(val binding: MainNewsItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            MainNewsItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
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