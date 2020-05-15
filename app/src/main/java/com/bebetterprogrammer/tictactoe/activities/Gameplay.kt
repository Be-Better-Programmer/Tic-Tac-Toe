package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_gameplay.*
import kotlinx.android.synthetic.main.activity_gameplay.appBottomLine

class Gameplay : AppCompatActivity() {
    var turn: Int = 0
    var first: Int = 0
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var won = 0
    var iswon = false

    init{
    turn = 0
    first = 0
    gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    won = 0
    iswon = false
}
    fun PlayerClick(view: View) {

        val img = view as ImageView
        val tappedImage = img.getTag().toString().toInt()
        if (gameState[tappedImage] == 2 && !iswon) {
            gameState[tappedImage] = turn
            if (turn == 0) {
                img.setImageResource(R.drawable.ic_circle_secondary)
            } else if (turn == 1) {
                img.setImageResource(R.drawable.ic_cross_yellow)
            }
            turn++
            turn %= 2
            img.animate().duration = 0
        }
        val obj = Iswin()
        iswon = obj.iswin(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"
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
