package com.example.kotlin.logger

interface LogNode {
    fun println(priority: Int, tag: String?, msg: String?, tr: Throwable?)// tr 可能为null
}