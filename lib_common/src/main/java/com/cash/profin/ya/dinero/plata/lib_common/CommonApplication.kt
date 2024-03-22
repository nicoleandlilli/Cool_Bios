package com.cash.profin.ya.dinero.plata.lib_common

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.cash.profin.ya.dinero.plata.lib_common.config.ModuleConfig

abstract class CommonApplication: MultiDexApplication(), IBaseApplication{

    companion object{
        private var mContext: Context? = null
        fun getContext() = mContext!!
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        initComponent()
    }

    private fun initComponent(){
        for(module in ModuleConfig.modules){
            try{
                val clazz = Class.forName(module)
                val baseApplication: IBaseApplication = clazz.newInstance() as IBaseApplication
                baseApplication.init()
            }catch (e: ClassNotFoundException){
                e.printStackTrace()
            }catch (e:IllegalAccessException){
                e.printStackTrace()
            }catch (e: InstantiationException){
                e.printStackTrace()
            }
        }
    }
}