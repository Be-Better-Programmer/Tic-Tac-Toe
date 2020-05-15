package com.bebetterprogrammer.tictactoe.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlin.random.Random
import kotlin.random.nextInt
import kotlinx.android.synthetic.main.activity_gameplay.appBottomLine
import kotlinx.android.synthetic.main.activity_gameplay.quit
import kotlinx.android.synthetic.main.activity_vs_jarvis.*
import kotlinx.android.synthetic.main.result_dialog.view.*

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
    var list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).toMutableList()
    val obj = Whowin()
    var pl = 0

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
        r = list[Random.nextInt(0..list.size - 1)]
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
        } else
            return getRandom()
    }

    fun PlayerClick(view: View) {
        val img = view as ImageView
        val tappedImage = img.getTag().toString().toInt()
        if (gameState[tappedImage] == 2 && !iswon && !istie) {
            gameState[tappedImage] = turn
            list.remove(tappedImage + 1)
            if (turn == 0) {
                img.setImageResource(R.drawable.ic_circle_secondary)
            } else if (turn == 1) {
                img.setImageResource(R.drawable.ic_cross_yellow)
            }
            free--
            img.animate().duration = 10
            iswon = obj.iswin(this)
            istie = obj.isTie(this)
            if (!iswon && !istie) {
                turn++
                turn %= 2
                putnew(getRandom())
            }
            if (iswon) {
                openDialogBox(view)
            } else if (istie) {
                openDialogBox(view)
            }
        }
    }

    fun putnew(o: ImageView) {
        if (turn == 0) {
            Handler().postDelayed({
                o.setImageResource(R.drawable.ic_circle_secondary)
            }, 800)
            gameState[isclicked] = turn
            list.remove(isclicked + 1)
        } else if (turn == 1) {
            Handler().postDelayed({
                o.setImageResource(R.drawable.ic_cross_yellow)
            }, 800)
            gameState[isclicked] = turn
            list.remove(isclicked + 1)
        }
        free--
        o.animate().duration = 0

        iswon = obj.iswin(this)
        istie = obj.isTie(this)
        if (!iswon && !istie) {
            turn++
            turn %= 2
        }
        if (iswon) {
            openDialogBox(o)
        } else if (istie) {
            openDialogBox(o)
        }
    }

    private fun openDialogBox(v: View) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View =
            LayoutInflater.from(v.context).inflate(R.layout.result_dialog, viewGroup, false)
        builder.setView(dialogView)
        val alertDialog: AlertDialog = builder.create()
        if (!istie) {
            if (obj.playerWon == true) {
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_won)
                dialogView.result.text = "Yeppii.. You Won!"
            } else {
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_lost)
                dialogView.result.text = "Ohh... You Lost!"
            }
        } else {
            dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_tie)
            dialogView.result.text = "That was a tie!"
        }
        Handler().postDelayed({ alertDialog.show() }, 800)
        dialogView.btnRematch.setOnClickListener {
            reset()
            alertDialog.dismiss()
        }

        dialogView.btnQuit.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }

    private fun reset() {
        for (i in 0..8) {
            gameState[i] = 2
        }
        var q = listOf<ImageView>(bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, bn9)
        for (i: ImageView in q) {
            i.setImageResource(0)
        }
        obj.playerWon = false
        won = 0
        iswon = false
        turn = pl
        istie = false
        list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).toMutableList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_jarvis)
        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"
        val intent = getIntent()
        val Weapon = intent.getIntExtra("Flag1", 0)
        val WhichFirst = intent.getIntExtra("Flag2", 0)
        val WhichLevel = intent.getIntExtra("Flag", 0)
        if (WhichLevel == 0 || WhichLevel == 1 || WhichLevel == 2) {
            player.text = "YOU"
            if (WhichFirst == 0) {
                first = 0 // O
            } else if (WhichFirst == 1) {
                first = 1 // X
            }
            if (Weapon == 0) {
                turn = 0 // your O
                pl = 0
            } else if (Weapon == 1) {
                turn = 1 // your X
                pl = 1
            }
            if (turn != first) {
                if (turn == 0) {
                    turn = 1
                } else {
                    turn = 0
                }
                putnew(getRandom())
            }
        }
        quit.setOnClickListener {
            val intentq = Intent(this, HomePageActivity::class.java)
            startActivity(intentq)
        }
    }
}
