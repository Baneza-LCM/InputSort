package com.example.sorteiodiceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()

        }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        diceImage.contentDescription = diceRoll.toString()


        val numDigitado = findViewById<EditText>(R.id.num_digitado).text.toString().toInt()

        if (numDigitado == diceRoll) {
            Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show()
        } else {
            if(numDigitado != diceRoll) {
                Toast.makeText(this, "Você perdeu!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Número inválido! Tente novamente com números de 1 à 6", Toast.LENGTH_SHORT).show()
            }
        }
    }

}



class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}