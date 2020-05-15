package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_gameplay.*
import kotlinx.android.synthetic.main.activity_gameplay.appBottomLine
import kotlinx.android.synthetic.main.activity_gameplay.quit
import kotlinx.android.synthetic.main.activity_vs_jarvis.*
import kotlin.random.Random
import kotlin.random.nextInt

class VsJarvis : AppCompatActivity() {
    var turn: Int = 0
    var first: Int = 0
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var won = 0
    var iswon = false
    var istie = false
    var free = 9
    var isclicked = 0
    var r = 0
    var list = listOf(1,2,3,4,5,6,7,8,9).toMutableList()
    val obj = Whowin()


    init {
        turn = 0
        first = 0
        gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
        won = 0
        iswon = false
        istie = false
        isclicked = 0
        r = 0
        free = 9
    }

    fun getRandom(): ImageView {
        r = list[Random.nextInt(0..list.size-1)]
        isclicked = r - 1
        if (r == 1 && gameState[isclicked] == 2) {
            return bn1
        } else if (r == 2 && gameState[isclicked] == 2) {
            return bn2
        } else if (r == 3 && gameState[isclicked] == 2) {
            return bn3
        } else if (r == 4 && gameState[isclicked] == 2) {
            return bn4
        } else if (r == 5 && gameState[isclicked] == 2) {
            return bn5
        } else if (r == 6 && gameState[isclicked] == 2) {
            return bn6
        } else if (r == 7 && gameState[isclicked] == 2) {
            return bn7
        } else if (r == 8 && gameState[isclicked] == 2) {
            return bn8
        } else if (r == 9 && gameState[isclicked] == 2) {
            return bn9
        }
        else
            return getRandom()
    }

    fun PlayerClick(view: View) {
        val img = view as ImageView
        val tappedImage = img.getTag().toString().toInt()
        if (gameState[tappedImage] == 2 && !iswon && !istie) {
            gameState[tappedImage] = turn
            list.remove(tappedImage+1)
            if (turn == 0) {
                img.setImageResource(R.drawable.ic_circle_secondary)
            } else if (turn == 1) {
                img.setImageResource(R.drawable.ic_cross_yellow)
            }
            free--
            img.animate().duration = 10
            iswon = obj.iswin(this)
            istie = obj.isTie(this)
            if(!iswon && !istie) {
                turn++
                turn %= 2
                putnew(getRandom())  // for jarvis
            }
        }
    }

    fun putnew(o: ImageView) {
        if (turn == 0) {
            o.setImageResource(R.drawable.ic_circle_secondary)
            gameState[isclicked] = turn
        } else if (turn == 1) {
            o.setImageResource(R.drawable.ic_cross_yellow)
            gameState[isclicked] = turn
        }
        free--
        o.animate().duration = 10
        iswon = obj.iswin(this)
        istie = obj.isTie(this)
        if(!iswon && !istie) {
            turn++
            turn %= 2
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_jarvis)

        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"
//        val intent = getIntent()
//        val P1 = intent.getStringExtra("Player1")

//        val Player = intent.getIntExtra("Player", 0)
//        player.text = P1
        player.text = "JONE"
        val Player = 0
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

