package com.dev.divig.findmovies.utils

import android.content.Context
import android.widget.Toast

object Utils {
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showToastLong(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun splitDate(value: String?): String {
        val date = if (value.isNullOrEmpty()) Constant.DEFAULT_DATE else value.toString()
        val result = date.split("-".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        return result[0]
    }
}
