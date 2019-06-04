package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var num: TextView
    private lateinit var num1: TextView
    private lateinit var fib: TextView
    private lateinit var pad: TextView
    private lateinit var sub: TextView
    private var number: Int = 0
    private var fibNum: Int = 0
    private var padNum: Int = 1
    private var compNum: Int = -1
    private lateinit var fibonacciNum: FibonacciNum
    private lateinit var padovanNum: PadovanNum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num = findViewById(R.id.num)
        num1 = findViewById(R.id.num1)
        fib = findViewById(R.id.fib)
        pad = findViewById(R.id.pad)
        sub = findViewById(R.id.sub)

        initial()
    }

    private fun initFibNum() {
        fibonacciNum = FibonacciNum(0, 1)
    }

    private fun initial() {
        initVariable()
        num.setText(number.toString())
        num1.setText(number.toString())
        fib.setText(fibNum.toString())
        pad.setText(padNum.toString())
        sub.setText(compNum.toString())
        number = 0
        initFibNum()
        initPadNum()
    }

    private fun initPadNum() {
        padovanNum = PadovanNum(1, 1, 1)
    }

    private fun initVariable() {
        fibNum = 0
        padNum = 1
        compNum = -1
        number = 0
    }

    fun addNumber(view: View) {
        number++
        num.setText(number.toString())
        num1.setText(number.toString())
        showfAddNumber()
        showpNumber()
        showComp()
    }

    fun showfAddNumber() {
        if (number >= 2) {
            fibNum = fibonacciNum.getNum()
            fib.setText(fibNum.toString())
        } else if (number == 1) {
            fibNum = 1
            fib.setText(fibNum.toString())
        }
    }

    private fun showpNumber() {
        if (number >= 3) {
            padNum = padovanNum.getNum()
            pad.setText(padNum.toString())
        } else {
            padNum = 1
            pad.setText(padNum.toString())
        }
    }

    fun subNumber(view: View) {
        if (number > 0) {
            number--
            num.setText(number.toString())
            num1.setText(number.toString())
            showfSubNum()
            showpSubNum()
            showComp()
        }
    }

    private fun showfSubNum() {
        if (number == 0) {
            fibNum = 0
            fib.setText(fibNum.toString())
        } else if (number >= 1) {
            fibNum = fibonacciNum.getSubNum()
            fib.setText(fibNum.toString())
        }
    }

    private fun showpSubNum() {
        if (number > 2) {
            padNum = padovanNum.getSubNum()
            pad.setText(padNum.toString())
        } else {
            padNum = 1
            pad.setText(padNum.toString())
            padovanNum = PadovanNum(1, 1, 1)
        }
    }

    fun doSubtraction(view: View) {
        showComp()
    }

    fun showComp(){
        sub.setText((fibNum-padNum).toString())
    }

    fun reset(view: View) {
        initial()
    }

}
