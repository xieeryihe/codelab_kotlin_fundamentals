package com.example.diceroller_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton:Button = findViewById(R.id.count_up_button)
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = (1).toString()
        rollButton.setOnClickListener { rollDice(resultText) }
        countUpButton.setOnClickListener{ countUp(resultText) }
    }
    private fun rollDice(resultText:TextView) {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }
    private fun countUp(resultText:TextView) {
        val num:Int? = resultText.text.toString().toIntOrNull()
        if (num!=null){
            if (num<6)
                    (num+1).toString().also { resultText.text = it }
        } else {
            Toast.makeText(this, "error",
                Toast.LENGTH_SHORT).show()
        }
    }
}