package com.bebetterprogrammer.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bebetterprogrammer.tictactoe.activities.HomePageActivity
import kotlinx.android.synthetic.main.activity_gameplay.*

class Gameplay : AppCompatActivity() {
    var turn: Int = 0
    var first: Int = 0
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

    // 0 = O      1 = X     2 = blank
    var winPosition = arrayOf(
        arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), arrayOf(0, 3, 6),
        arrayOf(1, 4, 7), arrayOf(2, 5, 8), arrayOf(0, 4, 8), arrayOf(2, 4, 6)
    )
    var won = 0
    fun PlayerClick(view: View) {
        val img = view as ImageView
        val tappedImage = img.getTag().toString().toInt()
        if (gameState[tappedImage] == 2 && won == 0) {
            gameState[tappedImage] = turn
            img.setTranslationY(-1000f)
            if (turn == 0) {
                img.setImageResource(R.drawable.circlenew)
            } else if (turn == 1) {
                img.setImageResource(R.drawable.crosnew)
            }
            turn++
            turn %= 2
            img.animate().translationYBy(1000f).setDuration(100)
        }
        for (winPosition in winPosition) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                // won
                if (turn == 1) {
                    if (won == 0) {
                        won = 1
                        var p1 = p1_winning.text.toString().toInt()
                        p1++
                        p1_winning.text = p1.toString()
                    }
                } else {
                    if (won == 0) {
                        won = 1
                        var p2 = p2_winning.text.toString().toInt()
                        p2++
                        p2_winning.text = p2.toString()
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
        val intent = getIntent()
        val P1 = intent.getStringExtra("Player1")
        val P2 = intent.getStringExtra("Player2")
        val Player = intent.getIntExtra("Player", 0)
        Player1.text = P1
        Player2.text = P2
        if (Player == 0) {
            first = 0
            turn = 0
        } else if (Player == 1) {
            turn = 1
            first = 1
        }
        quit.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}
