package com.exer7um.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    private var displayedText: TextView? = null
    private var expression: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayedText = findViewById(R.id.textView)
    }

    fun add(v: View) {
        val b: Button = v as Button
        val buttonText: String = b.text.toString()
        val signs = arrayOf('+', '−', '×', '÷')
        if (expression.isNotEmpty()) {
            if (expression.last() in signs && expression.last().toString() == buttonText) {
                expression.dropLast(1)
            } else {
                expression += buttonText
            }
            displayedText?.text = expression
        } else {
            if (buttonText.last() !in signs) {
                expression += buttonText
                displayedText?.text = expression
            }
        }
    }

    fun evaluate(v: View) {
        var num: String = ""
        var result: Double = 0.0
        var symbol: Char = '+'

        if (expression.isNotEmpty()) {
            for (i in expression) {
                if (i in '0'..'9' || i == '.') {
                    num += i
                } else {
                    when (symbol) {
                        '+' -> result += num.toDouble()
                        '-' -> result -= num.toDouble()
                        '×' -> result *= num.toDouble()
                        '÷' -> result /= num.toDouble()
                    }
                    num = ""
                    symbol = i
                }
            }
            when (symbol) {
                '+' -> result += num.toDouble()
                '−' -> result -= num.toDouble()
                '×' -> result *= num.toDouble()
                '÷' -> result /= num.toDouble()
            }
            displayedText?.text = result.toString()
            expression = ""
        }
    }

    fun clear(v: View) {
        expression = ""
        displayedText?.text = "0"
    }
}