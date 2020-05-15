package com.bebetterprogrammer.tictactoe.activities

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_gameplay.*
import kotlinx.android.synthetic.main.activity_gameplay.appBottomLine
import kotlinx.android.synthetic.main.activity_gameplay.quit
import kotlinx.android.synthetic.main.result_dialog.*
import kotlinx.android.synthetic.main.result_dialog.view.*

class GamePlayActivity : AppCompatActivity() {
    var turn: Int = 0
    var first: Int = 0
    var pl: Int = 0
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    lateinit var P1: String
    lateinit var P2: String

    // 0 = O      1 = X     2 = blank
    var won = 0
    var iswon = false
    var istie = false
    val obj = Iswin()

    init {
        turn = 0
        first = 0
        gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
        won = 0
        iswon = false
        istie = false
    }

    fun PlayerClick(view: View) {

        val img = view as ImageView
        val tappedImage = img.getTag().toString().toInt()
        if (gameState[tappedImage] == 2 && !iswon && !istie) {
            val tappedImage = img.tag.toString().toInt()
            if (gameState[tappedImage] == 2 && won == 0) {
                gameState[tappedImage] = turn
                if (turn == 0) {
                    img.setImageResource(R.drawable.ic_circle_secondary)
                } else if (turn == 1) {
                    img.setImageResource(R.drawable.ic_cross_yellow)
                }
                iswon = obj.iswin(this,view)
                istie = obj.isTie(this)
                if(iswon && turn == 1){
                    openDialogBox(view, P2)
                }
                else if(iswon && turn == 0){
                    openDialogBox(view, P1)
                }
                else if(istie){
                    openDialogBox(view,"That was a Tie!")
                }
                turn++
                turn %= 2
                img.animate().duration = 0
            }

        }
    }
    private fun openDialogBox(v: View, playerName: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View = LayoutInflater.from(v.context).inflate(R.layout.result_dialog, viewGroup, false)
        builder.setView(dialogView)
        val alertDialog: AlertDialog = builder.create()
        if(!istie) {
            dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_won)
            dialogView.result.text = "Yeppii.. $playerName Won!"
        }
        else{
            dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_tie)
            dialogView.result.text = playerName
        }
        alertDialog.show()

        dialogView.btnRematch.setOnClickListener {
            reset(v)
            alertDialog.dismiss()
        }

        dialogView.btnQuit.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

    }
    private fun reset(view: View){


        for (i in 0..8) {
            gameState[i] = 2
        }
    var q = listOf<ImageView>(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)
        for (i:ImageView in q){
            i.setImageResource(0)
        }
        won = 0
        iswon = false
        istie = false
        turn = pl

    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_gameplay)
            val versionName = BuildConfig.VERSION_NAME
            appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"

            val intent = intent
            P1 = intent.getStringExtra("Player1")
            P2 = intent.getStringExtra("Player2")
            val Player = intent.getIntExtra("Player", 0)
            Player1.text = P1
            Player2.text = P2
            if (Player == 0) {
                first = 0
                turn = 0
                pl = 0
            } else if (Player == 1) {
                turn = 1
                first = 1
                pl = 1
            }
            quit.setOnClickListener {
                val intent = Intent(this, HomePageActivity::class.java)
                startActivity(intent)
            }
        }
}
