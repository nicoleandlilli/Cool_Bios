package com.cash.profin.ya.dinero.plata.module_home


import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_home.adapter.NewsTopHeadLineAdapter
import com.cash.profin.ya.dinero.plata.module_home.bean.Article
import com.cash.profin.ya.dinero.plata.module_home.databinding.HomeFragmentHomeBinding
import com.cash.profin.ya.dinero.plata.module_home.databinding.HomeFragmentPopularBinding

@Route(path = RouterPaths.HOME_POPULAR)
//class HomeFragment:BaseFragment<HomeFragmentHomeBinding>() {
//    override fun getViewBinding(container: ViewGroup?)=HomeFragmentHomeBinding.inflate(layoutInflater)
//
//    override fun initView() {
//
//    }
//
//    override fun initData() {
//
//    }
//}

class HOME_POPULAR:BaseFragment<HomeFragmentPopularBinding>() {

    private var mCount:Int =0;
    private lateinit var mAdapter: NewsTopHeadLineAdapter
    private var mArticles = ArrayList<Article>()
    override fun getViewBinding(container: ViewGroup?)=HomeFragmentPopularBinding.inflate(layoutInflater)

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

            addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if(isSlideToBottom(this@apply)){
                        setAdapterData()
                        Toast.makeText(context,"加载更多", Toast.LENGTH_SHORT).show()
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

    private fun isSlideToBottom(recyclerView: RecyclerView):Boolean{

        return !recyclerView.isEmpty()&&
                (recyclerView.computeVerticalScrollExtent()+recyclerView.computeVerticalScrollOffset()>=
                        recyclerView.computeVerticalScrollRange())

    }
}