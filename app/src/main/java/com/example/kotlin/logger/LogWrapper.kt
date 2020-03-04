package com.example.kotlin.logger

import android.util.Log

class LogWrapper : LogNode{
    var next: LogNode? = null
    override fun println(priority: Int, tag: String?, msg: String?, tr: Throwable?) {
        var msgs = msg
        if (msgs == null) {
            msgs = "";
        }
        if (tr != null) {
            msgs += "\n${Log.getStackTraceString(tr)}"
        }
        Log.println(priority, tag, msgs);
        next?.println(priority, tag, msg, tr)
    }
}