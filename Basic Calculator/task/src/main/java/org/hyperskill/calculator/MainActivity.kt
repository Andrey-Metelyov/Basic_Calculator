package org.hyperskill.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var prev: Double? = null
    private var operation: Operation? = null
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var addButton: Button
    private lateinit var clearButton: Button
    private lateinit var divideButton: Button
    private lateinit var dotButton: Button
    private lateinit var equalButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var subtractButton: Button
    private lateinit var editText: EditText

    enum class Operation {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        addButton = findViewById(R.id.addButton)
        clearButton = findViewById(R.id.clearButton)
        divideButton = findViewById(R.id.divideButton)
        dotButton = findViewById(R.id.dotButton)
        equalButton = findViewById(R.id.equalButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        subtractButton = findViewById(R.id.subtractButton)
        editText = findViewById(R.id.editText)

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        addButton.setOnClickListener(this)
        clearButton.setOnClickListener(this)
        divideButton.setOnClickListener(this)
        dotButton.setOnClickListener(this)
        equalButton.setOnClickListener(this)
        multiplyButton.setOnClickListener(this)
        subtractButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button0 -> {
                if (editText.text.toString() != "0" && editText.text.toString() != "-") {
                    editText.text.append("0")
                }
            }
            R.id.button1 -> addDigit("1")
            R.id.button2 -> addDigit("2")
            R.id.button3 -> addDigit("3")
            R.id.button4 -> addDigit("4")
            R.id.button5 -> addDigit("5")
            R.id.button6 -> addDigit("6")
            R.id.button7 -> addDigit("7")
            R.id.button8 -> addDigit("8")
            R.id.button9 -> addDigit("9")
            R.id.dotButton -> {
                if (!editText.text.contains('.')) {
                    if (editText.text.toString() == "-") {
                        editText.text.append('0')
                    }
                    editText.text.append('.')
                }
            }
            R.id.clearButton -> {
                editText.text.clear()
                editText.text.append('0')
            }
            R.id.subtractButton -> {
                if (editText.text.toString() == "0") {
                    editText.text.clear()
                    editText.append("-")
                } else {
                    setOperation(Operation.MINUS)
                }
            }
            R.id.addButton -> setOperation(Operation.PLUS)
            R.id.divideButton -> setOperation(Operation.DIVIDE)
            R.id.multiplyButton -> setOperation(Operation.MULTIPLY)
            R.id.equalButton -> calculate()
        }
    }

    private fun calculate() {
        if (prev != null) {
            val result: Double
            val cur = editText.text.toString().toDouble()
            result = when (operation!!) {
                Operation.PLUS -> prev!! + cur
                Operation.MINUS -> prev!! - cur
                Operation.DIVIDE -> prev!! / cur
                Operation.MULTIPLY -> prev!! * cur
            }
            editText.text.clear()
            editText.text.append(result.toString())
        }
    }

    private fun setOperation(op: Operation) {
        prev = editText.text.toString().toDouble()
        operation = op
        editText.text.clear()
        editText.text.append('0')
    }

    private fun addDigit(text: String) {
        if (editText.text.toString() == "0") {
            editText.text.clear()
        }
        editText.text.append(text)
    }
}