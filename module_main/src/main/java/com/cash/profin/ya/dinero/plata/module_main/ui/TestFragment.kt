package com.cash.profin.ya.dinero.plata.module_main.ui

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_main.R
import com.cash.profin.ya.dinero.plata.module_main.adapter.NewsTopHeadLineAdapter
import com.cash.profin.ya.dinero.plata.module_main.bean.Article
import com.cash.profin.ya.dinero.plata.module_main.databinding.MainFragmentTestBinding
class TestFragment:BaseFragment<MainFragmentTestBinding>() {

    private var mCount:Int =0;
    private lateinit var mAdapter: NewsTopHeadLineAdapter
    private var mArticles = ArrayList<Article>()
    override fun getViewBinding(container: ViewGroup?)=MainFragmentTestBinding.inflate(layoutInflater)

    override fun initView() {

    }

    override fun initData() {
        setRecyclerView()

        mBinding.swipeRefreshLayout?.apply {
            setColorSchemeResources(R.color.teal_700)

            setOnRefreshListener {

                isRefreshing = false
            }
        }

    }

    private fun setRecyclerView() {
        mAdapter = NewsTopHeadLineAdapter()
        mBinding.recyclerView.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = linearLayoutManager

            val dividerDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerDecoration)

            addOnScrollListener(object:RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if(isSlideToBottom(this@apply)){
                        setAdapterData()
                        Toast.makeText(context,"加载更多",Toast.LENGTH_SHORT).show()
                    }

                }
            })

            adapter = mAdapter
        }



        setAdapterData()
    }

    private fun setAdapterData(){
        mArticles.addAll(getArticles())
        mAdapter.setArticleList(mArticles)
    }


    fun getArticles():ArrayList<Article>{
        var articles = ArrayList<Article>()
        for(i in 1..10){
            var article = Article("Title${mCount++}","")
            articles.add(article)
        }

        return articles
    }

    private fun isSlideToBottom(recyclerView:RecyclerView):Boolean{

        return !recyclerView.isEmpty()&&
                (recyclerView.computeVerticalScrollExtent()+recyclerView.computeVerticalScrollOffset()>=
                recyclerView.computeVerticalScrollRange())

    }
}