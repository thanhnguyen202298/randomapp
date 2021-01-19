package com.thanh.random

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes


fun ViewGroup.setContentView(@LayoutRes id: Int) {
    LayoutInflater.from(context).inflate(id, this, true)
}