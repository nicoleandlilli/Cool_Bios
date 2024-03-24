package com.cash.profin.ya.dinero.plata.module_home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.ViewBinding
import com.cash.profin.ya.dinero.plata.module_base.viewmodel.BaseViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(): BaseViewModel() {

    var mMutableLiveDataTask : MutableLiveData<Task<QuerySnapshot>?> = MutableLiveData()


    fun getMessageInfo(binding: ViewBinding) {
        var task: Task<QuerySnapshot>? = null

        viewModelScope.launch {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            task = db.collection("message")
                .whereGreaterThanOrEqualTo("favarite_number", 500)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && task.result.size() > 0) {
                        mMutableLiveDataTask.postValue(task)
                    } else {
                        Log.w("HomeFragment", "Error getting documents.", task.exception)
                    }
                }
        }
    }

    fun getMutableLiveDataTask():MutableLiveData<Task<QuerySnapshot>?>{
        return mMutableLiveDataTask
    }

//    suspend fun getMessageInfo(binding: ViewBinding): Task<QuerySnapshot>? {
//        var task: Task<QuerySnapshot>? = null
//
//        var job = viewModelScope.launch {
//            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
//            task= db.collection("message")
//                .whereGreaterThanOrEqualTo("favarite_number",500)
//                .get()
//            mMutableLiveDataTask.postValue(task)
//        }
//        job.join()
//
//        return task
//
//    }

    suspend fun getFemaleMessageInfo(binding: ViewBinding): Task<QuerySnapshot>? {
        var task: Task<QuerySnapshot>? = null

        var job = viewModelScope.launch {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            task= db.collection("message")
                .where(Filter.and(
                    Filter.greaterThanOrEqualTo("favarite_number",500),
                    Filter.equalTo("gender","female")
                ))
            .get()
        }
        job.join()

        return task

    }


    suspend fun getMaleMessageInfo(binding: ViewBinding): Task<QuerySnapshot>? {
        var task: Task<QuerySnapshot>? = null

        var job = viewModelScope.launch {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            task= db.collection("message")
                .where(Filter.and(
                    Filter.greaterThanOrEqualTo("favarite_number",500),
                    Filter.equalTo("gender","male")
                ))
            .get()
        }
        job.join()

        return task

    }
}