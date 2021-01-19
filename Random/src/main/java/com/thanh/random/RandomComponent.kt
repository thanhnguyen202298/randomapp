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

    fun onRandomNumber() {
        val res = random.nextInt(10)
        titletxt.text = "$res"
    }

    fun onRandomWord(inRange: ArrayList<String> = ArrayList()):String {
        var alpha = ""
        if (inRange.size == 0) {
            val res = random.nextInt(25)
            alpha = arrayRandomAlpha[res]
            titletxt.text = "$alpha"
        } else {
            val size = inRange.size
            val res = random.nextInt(size - 1)
            alpha = inRange[res]
            titletxt.text = "$alpha"
        }
        return alpha
    }

    fun random(inRange: ArrayList<String> = ArrayList()):String {
        val isNumber = radioNumber.isChecked
        if (isNumber)
            onRandomNumber()
        else
            return onRandomWord(inRange)
        return ""
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