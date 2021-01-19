package com.thanh.random

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.android.synthetic.main.random_content.view.*
import kotlinx.android.synthetic.main.random_text.view.*
import kotlinx.android.synthetic.main.random_text.view.titletxt

class RandomComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), LifecycleObserver {

    var mylayout = false
    init {
        LayoutInflater.from(context).inflate(R.layout.random_content, this, true)
    }

    fun onRandomNumber():Int {
        val res = random.nextInt(10)
        titletxt.text = "$res"
        return res
    }

    fun onRandomWord(inRange: ArrayList<String> = ArrayList()):Int {
        var res = 0
        if (inRange.size == 0) {
            res = random.nextInt(25)
            val alpha = arrayRandomAlpha[res]
            titletxt.text = "$alpha"
        } else {
            val size = inRange.size
            res = random.nextInt(size - 1)
            val alpha = inRange[res]
            titletxt.text = "$alpha"
        }
        return res
    }

    fun random(inRange: ArrayList<String> = ArrayList()):Int {
        val isNumber = radioNumber.isChecked
        return if (isNumber)
            onRandomNumber()
        else
             onRandomWord(inRange)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {

    }
}