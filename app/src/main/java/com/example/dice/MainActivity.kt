package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setting Up the Button
        val rollButton:Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()//Toast to tell that dice is rolled even if face doesn't change
            rollDice()


        }
    }
    //Roll the dice and update the screen
    private fun rollDice() {
        
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultImageView :ImageView = findViewById(R.id.imageView)
        val image = when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6}

        resultImageView.setImageResource(image)
        resultImageView.contentDescription = dice.toString()
    }
}

//The Dice object class
class Dice(private val sides:Int){
    fun roll():Int{
        return (1..sides).random()
    }
}
