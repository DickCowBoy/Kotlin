package com.example.kotlin.logger

//singleton
//Command Line Compiler
//Running Code Snippets
//Working with Build Tools
//Koans
//Competitive Programming
//Asynchronous Programming
//Intro to Kotlin Coroutines on the JVM
//Intro to Coroutines and Channels
//Edit Page
//Objects and companion objects
//Object declarations
//
//If you need a singleton - a class that only has got one instance - you can declare the class in the usual way, but use the object keyword instead of class
object Log {
    val NONE = -1
    val VERBOSE = android.util.Log.VERBOSE
    val DEBUG = android.util.Log.DEBUG
    val INFO = android.util.Log.INFO
    val WARN = android.util.Log.WARN
    val ERROR = android.util.Log.ERROR
    val ASSERT = android.util.Log.ASSERT

    var logNode: LogNode? = null;

    fun println(priority: Int, tag: String, msg: String?, tr: Throwable?) {
        logNode?.println(priority, tag, msg, tr)
    }

    fun v(tag: String, msg: String? = null, tr: Throwable? = null) {// 默认值null
        println(VERBOSE, tag, msg, tr);
    }

    fun d(tag: String, msg: String? = null, tr: Throwable? = null) {
        println(DEBUG, tag, msg, tr)
    }

    fun i(tag: String, msg: String? = null, tr: Throwable? = null) {
        println(INFO, tag, msg, tr)
    }

    fun w(tag: String, msg: String? = null, tr: Throwable? = null) {
        println(WARN, tag, msg, tr)
    }

    fun e(tag: String, msg: String, tr: Throwable? = null) {
        println(ERROR, tag, msg, tr)
    }

    fun wtf(tag: String, msg: String? = null, tr: Throwable? = null) {
        println(ASSERT, tag, msg, tr)
    }
}