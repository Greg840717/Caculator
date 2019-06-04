package com.example.calculator

class PadovanNum(pn3: Int, pn2: Int, pn1: Int) {

    private var pn1: Int
    private var pn2: Int
    private var pn3: Int
    private var padNum: Int

    init {
        this.pn3 = pn3
        this.pn2 = pn2
        this.pn1 = pn1
        padNum = pn3 + pn2
    }

    fun getNum(): Int {
        padNum = pn3 + pn2
        pn3 = pn2
        pn2 = pn1
        pn1 = padNum
        return padNum
    }

    fun getSubNum(): Int {
        var p:Int=pn1-pn3
        padNum = pn2
        pn1 = padNum
        pn2 = pn3
        pn3 = p
        return padNum
    }
}