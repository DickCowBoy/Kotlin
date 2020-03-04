package com.example.kotlin.logger

import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment

class LogFragment : Fragment() {
    lateinit var logView: LogView
    private lateinit var scrollView: ScrollView

    private fun inflateViews(): View {
        scrollView = ScrollView(activity)
        val param = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        scrollView.layoutParams = param
        val logparam = ViewGroup.LayoutParams(param)
        logparam.height = ViewGroup.LayoutParams.WRAP_CONTENT
        with(logView) {// 1.让代码快在这对象内部运行
            layoutParams = logparam
            isClickable = true
            isFocusable = true
            typeface = Typeface.MONOSPACE
        }

        scrollView.addView(logView)
        return scrollView
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var result = inflateViews()
        logView.addTextChangedListener(object : TextWatcher {// 2.接口所以需要添加object
            override fun afterTextChanged(p0: Editable?) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

        })
        return result
    }
}