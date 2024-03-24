package com.cash.profin.ya.dinero.plata.module_credit


import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.cash.profin.ya.dinero.plata.lib_common.config.PrefsConfig
import com.cash.profin.ya.dinero.plata.lib_common.utils.PrefsUtil
import com.cash.profin.ya.dinero.plata.module_base.constants.RouterPaths
import com.cash.profin.ya.dinero.plata.module_base.ui.BaseFragment
import com.cash.profin.ya.dinero.plata.module_credit.databinding.HomeFragmentLatestBinding
import com.cash.profin.ya.dinero.plata.module_home.adapter.LatestMessageAdapter
import com.cash.profin.ya.dinero.plata.module_home.viewmodel.HomeLatesetViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

@Route(path = RouterPaths.HOME_LATEST)
class HomeLatestFragment:BaseFragment<HomeFragmentLatestBinding>() {
    private lateinit var mAdapter: LatestMessageAdapter

    private val mHomeViewModel: HomeLatesetViewModel by viewModels()
    override fun getViewBinding(container: ViewGroup?)=HomeFragmentLatestBinding.inflate(layoutInflater)

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

        mHomeViewModel.getMutableLiveDataTask().observe(this, Observer { task: Task<QuerySnapshot>? ->
            mBinding.swipeRefreshLayout.isRefreshing = false
            if (task != null) {
                var documentSnapshots : ArrayList<DocumentSnapshot> = task.result.documents as ArrayList<DocumentSnapshot>
                mAdapter.setArticleList(documentSnapshots)
            }else{
                var documentSnapshots : ArrayList<DocumentSnapshot> = ArrayList<DocumentSnapshot>() as ArrayList<DocumentSnapshot>
                mAdapter.setArticleList(documentSnapshots)
            }
        })

    }

    private fun setRecyclerView() {
        mAdapter = LatestMessageAdapter()
        mBinding.recyclerView.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = linearLayoutManager

//            val dividerDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
//            addItemDecoration(dividerDecoration)

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
        getData()
    }

    private fun getData() {
        mBinding.swipeRefreshLayout.isRefreshing = true
        var gender:String by PrefsUtil(PrefsConfig.GENDER, PrefsConfig.GENDER_BOTH)
        if(gender== PrefsConfig.GENDER_BOTH){
            mHomeViewModel.getMessageInfo()
        }else if(gender== PrefsConfig.GENDER_FEMALE){
            mHomeViewModel.getFemaleMessageInfo()
        }else{
            mHomeViewModel.getMaleMessageInfo()
        }
    }



    private fun isSlideToBottom(recyclerView: RecyclerView):Boolean{

        return !recyclerView.isEmpty()&&
                (recyclerView.computeVerticalScrollExtent()+recyclerView.computeVerticalScrollOffset()>=
                        recyclerView.computeVerticalScrollRange())

    }



}