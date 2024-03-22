package com.cash.profin.ya.dinero.plata.module_base.constants

interface RouterPaths {

    companion object{
        const val HOME_FRAGMENT = "/home/home_fragment"
        const val CREDIT_FRAGMENT = "/credit/credit_fragment"
        const val MINE_FRAGMENT = "/mine/mine_fragment"

        val MAIN_FRAGMENTS =
            arrayOf(HOME_FRAGMENT, CREDIT_FRAGMENT, MINE_FRAGMENT)
    }
}