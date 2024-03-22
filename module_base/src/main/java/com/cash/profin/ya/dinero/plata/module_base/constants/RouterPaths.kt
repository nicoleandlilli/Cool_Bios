package com.cash.profin.ya.dinero.plata.module_base.constants

interface RouterPaths {

    companion object{
        const val HOME_POPULAR = "/popular/home_popular"
        const val HOME_LATEST = "/latest/home_latest"
        const val MINE_FRAGMENT = "/mine/mine_fragment"

        val MAIN_FRAGMENTS =
            arrayOf(HOME_POPULAR, HOME_LATEST)
    }
}