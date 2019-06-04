package com.example.calculator

class FibonacciNum(before: Int, recent: Int) {

    var fibNum: Int
    var recentNum: Int
    var beforeNum: Int

    init {
        this.beforeNum = before
        this.recentNum = recent
        this.fibNum = before + recent
    }


    fun getNum(): Int {
        fibNum = beforeNum + recentNum
        beforeNum = recentNum
        recentNum = fibNum
        return fibNum
    }

    fun getSubNum():Int{
        var f :Int = fibNum
        var r :Int = beforeNum
        fibNum = beforeNum
        recentNum = fibNum
        beforeNum = f - r
        return fibNum
    }
}