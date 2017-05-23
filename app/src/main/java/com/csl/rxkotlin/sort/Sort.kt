package com.csl.rxkotlin.sort

/**
 * author: laichangsen | create time: 2017/5/23
 */
interface Sort {

    fun sort(list : MutableList<Int>)

    fun getTestData() : MutableList<Int> {
        return mutableListOf(4, 5, 1, 6, 3, 2)
    }
}