package com.thanh.randomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.get
import com.thanh.random.RandomComponent
import com.thanh.random.arrayRandomEm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createComponent(): RandomComponent {
        val m = RandomComponent(this)
        val layout = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        m.layoutParams = layout
        return m
    }

    fun countComponent(): Int {
        return parentrandom.childCount
    }

    fun clickApplyNumber(v: View) {
        val n = numkey.text.toString().toInt()
        val m = n - countComponent()
        if (m < 0)
            decreaseView(Math.abs(m))
        else increaseView(m)
    }

    fun decreaseView(n: Int) {
        for (i in 0..n) {
            if (countComponent() > 0)
                parentrandom.removeViewAt(countComponent() - 1)
        }
    }

    fun increaseView(n: Int) {
        for (i in 0..n) {
            val view = createComponent()
            parentrandom.addView(view)
        }
    }

    var Arraytmp: List<String> = ArrayList()

    fun startRandom(v: View) {
        val n = countComponent() - 1
        for (i in 0..n) {
            val compo = parentrandom.get(i) as RandomComponent
            if (haveOpposite.isChecked && (i == 2 || i == n)) {
                if (Arraytmp.size > 0)
                    compo.random(Arraytmp as ArrayList<String>)
                else compo.random()
            } else if (haveOpposite.isChecked && (i == 0)) {
                opposite(compo.random())
            } else
                compo.random()

        }
    }

    fun opposite(index: Int) {
        val c = arrayRandomEm[index]
        val seps = c.split("").filter { it.isNotEmpty() }
        val n = seps.size - 1
        Arraytmp = arrayRandomEm.filter {
            var y = false
            for (i in 0..n) {
                y = it.contains(seps[i])
                if (y) break
            }
            y
        }


    }
}