package com.csl.rxkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import java.util.concurrent.TimeUnit

/**
 * author: laichangsen | create time: 2017/5/21
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.interval_btn -> rxInterval()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        interval_btn.setOnClickListener(this)
    }

    fun rxInterval() {
        Observable
                .interval(0, 1, TimeUnit.SECONDS) // 0秒延迟，每隔1秒发送一条数据
                .take(5) // 发送次数
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ num ->
                    val numUI = 5 - num
                    this.interval_btn.text = numUI.toString()
                })
    }
}
