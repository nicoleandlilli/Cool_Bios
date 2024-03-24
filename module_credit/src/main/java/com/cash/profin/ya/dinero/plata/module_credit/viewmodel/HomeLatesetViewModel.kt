package com.cash.profin.ya.dinero.plata.module_credit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cash.profin.ya.dinero.plata.module_base.viewmodel.BaseViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class HomeLatesetViewModel(): BaseViewModel() {

    var mMutableLiveDataTask : MutableLiveData<Task<QuerySnapshot>?> = MutableLiveData()


    fun getMessageInfo() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,-2); //前两天的时间
            val date: Date = calendar.time

            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
             db.collection("message")
                 .whereGreaterThanOrEqualTo("timestamp", date)
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
            val calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,-2); //前两天的时间
            val date: Date = calendar.time

            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            db.collection("message")
                .where(Filter.and(
                    Filter.greaterThanOrEqualTo("timestamp", date),
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
            val calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,-2); //前两天的时间
            val date: Date = calendar.time

            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            db.collection("message")
                .where(Filter.and(
                    Filter.greaterThanOrEqualTo("timestamp", date),
                    Filter.equalTo("gender","male")
                ))
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
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