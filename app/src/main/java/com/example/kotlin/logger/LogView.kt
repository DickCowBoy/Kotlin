package com.example.kotlin.logger

import android.app.Activity
import android.content.Context
import android.util.AttributeSet

class LogView : androidx.appcompat.widget.AppCompatTextView, LogNode {

    var next: LogNode? = null;

    @JvmOverloads// 1.相当于多个重载函数
    constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
            super(context, attrs, defStyle)

    override fun println(priority: Int, tag: String?, msg: String?, tr: Throwable?) {
        val priorityStr = when (priority) {//2.switch
            android.util.Log.ASSERT -> "VERBOSE"
            android.util.Log.ERROR -> "ERROR"
            android.util.Log.WARN -> "WARN"
            android.util.Log.DEBUG -> "DEBUG"
            android.util.Log.INFO -> "INFO"
            else -> null
        }

        val exceptionStr = tr?.let { android.util.Log.getStackTraceString(tr) }

        val outputBuilder = StringBuilder()
        val delimiter = "\t"

        appendIfNotNull(outputBuilder, priorityStr, delimiter)
        appendIfNotNull(outputBuilder, tag, delimiter)
        appendIfNotNull(outputBuilder, msg, delimiter)
        appendIfNotNull(outputBuilder, exceptionStr, delimiter)

        (context as Activity).runOnUiThread {//3. 类型转换
            appendToLog(outputBuilder.toString())
        }

    }

    private fun appendIfNotNull(source: StringBuilder, addStr: String?, delimiter: String) :StringBuilder {
        if (addStr != null && addStr.isNotEmpty()) {// isNotEmpty
            source.append(addStr)
        }
        return source
    }

    private fun appendToLog(s: String) {
        append(s)
    }
}