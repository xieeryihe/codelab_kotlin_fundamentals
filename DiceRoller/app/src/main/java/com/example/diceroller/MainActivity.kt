package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage1 : ImageView
    private lateinit var diceImage2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image_1)
        diceImage2 = findViewById(R.id.dice_image_2)
        val rollButton: Button = findViewById(R.id.roll_button)
        val clearButton: Button = findViewById(R.id.clear_button)
        rollButton.setOnClickListener { rollDice() }
        clearButton.setOnClickListener { clearDice() }
    }
    private fun rollDice() {
        diceImage1.setImageResource( getRandomDiceImage() )
        diceImage2.setImageResource( getRandomDiceImage() )
    }
    private fun getRandomDiceImage() : Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
    private fun clearDice() {
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }
}