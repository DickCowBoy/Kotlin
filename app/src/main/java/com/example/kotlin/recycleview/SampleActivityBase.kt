package com.example.kotlin.recycleview

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.kotlin.logger.Log
import com.example.kotlin.logger.LogWrapper

//open:在java中允许创建任意的子类并重写方法任意的方法，除非显示的使用了final关键字进行标注，
// 在kotlin的世界里面则不是这样，在kotlin中它所有的类默认都是final的，那么就意味着不能被继承，
// 而且在类中所有的方法也是默认是final的，那么就是kotlin的方法默认也不能被重写
open class SampleActivityBase(contentLayoutId: Int) : FragmentActivity()
/*A class in Kotlin can have a primary constructor and one or more secondary constructors.
The primary constructor is part of the class header: it goes after the class name (and optional type parameters).*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    open fun initializeLogging() {
        Log.logNode = LogWrapper()
        Log.i(TAG, "Log init")
    }

    //If you need a function or a property to be tied to a class rather than to instances o
    // f it (similar to @staticmethod in Python), you can declare it inside a companion object
    companion object {
        // 伴生对象
        const val TAG =
            "SampleActivityBase"//1.const val 和val区别，可以通过tool>kotlin->bytecode const只能修饰val，const只能top-level级别继object中使用
        // const val == public static final val == private static final(并且生成getNormalObject()方法)
    }

    override fun onStart() {
        super.onStart()
        initializeLogging()
    }
}