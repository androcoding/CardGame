package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var playerCard: ImageView
    lateinit var cpuCard: ImageView
    lateinit var playerScore: TextView
    lateinit var cpuScore: TextView
    lateinit var buttonDeal: Button
    var playerScores = 0
    var cpuScores = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerCard = findViewById(R.id.playerCard)
        cpuCard = findViewById(R.id.cpuCard)
        playerScore = findViewById(R.id.playerRun)
        cpuScore = findViewById(R.id.cpuRun)
        buttonDeal = findViewById(R.id.dealButton)
        buttonDeal.setOnClickListener {
            val playerCardNumber = (2..14).random()
            val cpuCardNumber = (2..14).random()
            val playerCardResources = when (playerCardNumber) {
                2 -> R.drawable.card2
                3 -> R.drawable.card3
                4 -> R.drawable.card4
                5 -> R.drawable.card5
                6 -> R.drawable.card6
                7 -> R.drawable.card7
                8 -> R.drawable.card8
                9 -> R.drawable.card9
                10 -> R.drawable.card10
                11 -> R.drawable.card11
                12 -> R.drawable.card12
                13 -> R.drawable.card13
                else -> R.drawable.card14
            }
            val cpuCardResources = when (cpuCardNumber) {
                2 -> R.drawable.card2
                3 -> R.drawable.card3
                4 -> R.drawable.card4
                5 -> R.drawable.card5
                6 -> R.drawable.card6
                7 -> R.drawable.card7
                8 -> R.drawable.card8
                9 -> R.drawable.card9
                10 -> R.drawable.card10
                11 -> R.drawable.card11
                12 -> R.drawable.card12
                13 -> R.drawable.card13
                else -> R.drawable.card14
            }

            playerCard.setImageResource(playerCardResources)
            cpuCard.setImageResource(cpuCardResources)
            if (playerCardNumber > cpuCardNumber) {
                playerScores+=1
                playerScore.text = playerScores.toString()
                Toast.makeText(this,"here won player by $playerScores",Toast.LENGTH_SHORT).show()

            } else if (cpuCardNumber > playerCardNumber) {
                cpuScores+=1
                cpuScore.text = cpuScores.toString()
                Toast.makeText(this,"here won cpu by $cpuScores",Toast.LENGTH_SHORT).show()
            } else {
                playerScores+=1
                cpuScores+=1
                playerScore.text = cpuScores.toString()
                cpuScore.text = cpuScores.toString()
                Toast.makeText(this,"here draw match  $playerScores and $cpuScores",Toast.LENGTH_SHORT).show()
            }


        }
    }
}