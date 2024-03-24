package com.cash.profin.ya.dinero.plata.module_home


import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.constants.ViewtTypeConstants
import com.cash.profin.ya.dinero.plata.module_base.listener.ViewClickListener
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_home.adapter.NewsTopHeadLineAdapter
import com.cash.profin.ya.dinero.plata.module_home.bean.Article
import com.cash.profin.ya.dinero.plata.module_home.databinding.HomeFragmentPopularBinding
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore


@Route(path = RouterPaths.HOME_POPULAR)

class HomePopular:BaseFragment<HomeFragmentPopularBinding>(),ViewClickListener {

    private var mCount:Int =0;
    private lateinit var mAdapter: NewsTopHeadLineAdapter
    private var mArticles = ArrayList<Article>()
    override fun getViewBinding(container: ViewGroup?)=HomeFragmentPopularBinding.inflate(layoutInflater)

    override fun initView() {

    }

    override fun initData() {
        setRecyclerView()

        mBinding.swipeRefreshLayout?.apply {
            setColorSchemeResources(R.color.pink)

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

//            addOnScrollListener(object: RecyclerView.OnScrollListener(){
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    if(isSlideToBottom(this@apply)){
//                        setAdapterData()
//                        Toast.makeText(context,"加载更多", Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//            })

            adapter = mAdapter
        }




    }

    override fun onResume() {
        super.onResume()
        setAdapterData()
    }

    private fun setAdapterData(){
//        mArticles.addAll(getArticles())
//        mAdapter.setArticleList(mArticles)
        Thread(Runnable {
            getData()
        }).start()

    }

    private fun getData() {
        mBinding.swipeRefreshLayout.isRefreshing = true
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("message")
            .whereGreaterThanOrEqualTo("favarite_number",500)
            .get()
                    .addOnCompleteListener { task ->
                        mBinding.swipeRefreshLayout.isRefreshing = false
                        if (task.isSuccessful && task.result.size()>0) {

                        var documentSnapshots : ArrayList<DocumentSnapshot> = task.result.documents as ArrayList<DocumentSnapshot>
                         mAdapter.setArticleList(documentSnapshots)
//                    for (document in task.result) {
////                        QueryDocumentSnapshot
//                        Log.d("HomeFragment", document.id + " => " + document.data)
//
//                        var gender:String = document["gender"].toString();
//                        Log.d("HomeFragment", "gender  => " + gender)
//
//                        var name:String = document["name"].toString();
//                        Log.d("HomeFragment", "name  => " + name)
//
//                        var age:Long = document["age"] as Long;
//                        Log.d("HomeFragment", "age  => " + age)
//
//                        var hobby:String = document["hobby"].toString();
//                        Log.d("HomeFragment", "hobby  => " + hobby)
//                    }
                } else {
                    Log.w("HomeFragment", "Error getting documents.", task.exception)
                }
            }
    }



    private fun isSlideToBottom(recyclerView: RecyclerView):Boolean{

        return !recyclerView.isEmpty()&&
                (recyclerView.computeVerticalScrollExtent()+recyclerView.computeVerticalScrollOffset()>=
                        recyclerView.computeVerticalScrollRange())

    }


    override fun onClick(type: Int, obj2: Object) {
        if(type == ViewtTypeConstants.VIEW_GENDER){
            Toast.makeText(context,"收到了性别的提示",Toast.LENGTH_SHORT).show()
        }
    }
}