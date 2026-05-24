package com.example.ca

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputBox = findViewById<EditText>(R.id.input_box)
        val digitTotal = findViewById<TextView>(R.id.digit_total)

        findViewById<MaterialButton>(R.id.key0).setOnClickListener{
            inputBox.append("0")
        }
        findViewById<MaterialButton>(R.id.key1).setOnClickListener{
            inputBox.append("1")
        }
        findViewById<MaterialButton>(R.id.key2).setOnClickListener{
            inputBox.append("2")
        }
        findViewById<MaterialButton>(R.id.key3).setOnClickListener{
            inputBox.append("3")
        }
        findViewById<MaterialButton>(R.id.key4).setOnClickListener{
            inputBox.append("4")
        }
        findViewById<MaterialButton>(R.id.key5).setOnClickListener{
            inputBox.append("5")
        }
        findViewById<MaterialButton>(R.id.key6).setOnClickListener{
            inputBox.append("6")
        }
        findViewById<MaterialButton>(R.id.key7).setOnClickListener{
            inputBox.append("7")
        }
        findViewById<MaterialButton>(R.id.key8).setOnClickListener{
            inputBox.append("8")
        }
        findViewById<MaterialButton>(R.id.key9).setOnClickListener{
            inputBox.append("9")
        }
        findViewById<MaterialButton>(R.id.dot).setOnClickListener{
            inputBox.append(".")
        }
        findViewById<MaterialButton>(R.id.add).setOnClickListener{

            inputBox.append("+")
        }
        findViewById<MaterialButton>(R.id.subtract).setOnClickListener{
            inputBox.append("-")
        }
        findViewById<MaterialButton>(R.id.multiply).setOnClickListener{
            inputBox.append("×")
        }
        findViewById<MaterialButton>(R.id.devide).setOnClickListener{
            inputBox.append("÷")
        }
        findViewById<MaterialButton>(R.id.delete).setOnClickListener {
            inputBox.text.clear()
            digitTotal.text=""
        }
        findViewById<MaterialButton>(R.id.backspace).setOnClickListener {
            val currentText = inputBox.text.toString()
            if (currentText.isNotEmpty()){
                inputBox.setText(currentText.dropLast(1))
            }
        }

        findViewById<MaterialButton>(R.id.equal).setOnClickListener {

            val correctExpressions = inputBox.text.toString()
                .replace("÷", "/")
                .replace("×", "*")
                .replace("−", "-")
            val expressions = ExpressionBuilder(correctExpressions).build()
            val result = expressions.evaluate()
            val longResult = result.toLong()
            if(result == longResult.toDouble()){
                digitTotal.text = longResult.toString()
            }
            else{
                digitTotal.text = result.toString()
            }
        }
        }

    }
