package com.cash.profin.ya.dinero.plata.module_home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cash.profin.ya.dinero.plata.module_base.viewmodel.BaseViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.launch

class HomeLatesetViewModel(): BaseViewModel() {

    var mMutableLiveDataTask : MutableLiveData<Task<QuerySnapshot>?> = MutableLiveData()


    fun getMessageInfo() {
        viewModelScope.launch {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
             db.collection("message")
                .whereGreaterThanOrEqualTo("favarite_number", 500)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && task.result.size() > 0) {
                        mMutableLiveDataTask.postValue(null)
                        mMutableLiveDataTask.postValue(task)
                    } else {
                        Log.w("HomeFragment", "Error getting documents.", task.exception)
                    }
                }
        }
    }

    fun getFemaleMessageInfo(){
        viewModelScope.launch {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            db.collection("message")
                .where(Filter.and(
                    Filter.greaterThanOrEqualTo("favarite_number",500),
                    Filter.equalTo("gender","female")
                ))
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && task.result.size() > 0) {
                        mMutableLiveDataTask.postValue(null)
                        mMutableLiveDataTask.postValue(task)
                    } else {
                        Log.w("HomeFragment", "Error getting documents.", task.exception)
                    }
                }
        }
    }

    fun getMaleMessageInfo(){
        viewModelScope.launch {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            db.collection("message")
                .where(Filter.and(
                    Filter.greaterThanOrEqualTo("favarite_number",500),
                    Filter.equalTo("gender","male")
                ))
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && task.result.size() > 0) {
                        mMutableLiveDataTask.postValue(null)
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

}