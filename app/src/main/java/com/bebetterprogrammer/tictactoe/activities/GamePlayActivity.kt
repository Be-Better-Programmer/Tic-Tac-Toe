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
import com.bebetterprogrammer.tictactoe.utils.GamePlayUtility
import com.bebetterprogrammer.tictactoe.utils.Result
import kotlinx.android.synthetic.main.activity_gameplay.*
import kotlinx.android.synthetic.main.activity_gameplay.appBottomLine
import kotlinx.android.synthetic.main.activity_gameplay.quit
import kotlinx.android.synthetic.main.result_dialog.view.*
import kotlin.properties.Delegates
import kotlin.random.Random
import kotlin.random.nextInt

class GamePlayActivity : AppCompatActivity() {
    var turn: Int = 0
    var first: Int = 0
    var pl: Int = 0
    var fl: Int = 0
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    lateinit var p1: String
    lateinit var p2: String
    var player by Delegates.notNull<Int>()
    var vsWhom by Delegates.notNull<Int>()
    var weapon by Delegates.notNull<Int>()
    var whichFirst by Delegates.notNull<Int>()
    var whichLevel by Delegates.notNull<Int>()

    // 0 = O      1 = X     2 = blank
    private val obj = GamePlayUtility()
    var r = 0
    var list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8).toMutableList()
    var isclicked = 0

    fun playerClick(view: View) {
        val img = view as ImageView
        val tappedImage = img.tag.toString().toInt()
        if (vsWhom == 0) {
            if (gameState[tappedImage] == 2 && obj.result != Result.TIE && obj.result != Result.WON) {
                gameState[tappedImage] = turn
                if (turn == 0) {
                    img.setImageResource(R.drawable.ic_circle_secondary)
                } else if (turn == 1) {
                    img.setImageResource(R.drawable.ic_cross_yellow)
                }
                img.animate().duration = 0
                obj.isWin(
                    gameState,
                    vsWhom,
                    turn,
                    p1_winning,
                    p2_winning,
                    pl,
                    player1_trophy,
                    player2_trophy
                )
                if (obj.result == Result.WON && turn == 1) {
                    openDialogBox(view, p2)
                } else if (obj.result == Result.WON && turn == 0) {
                    openDialogBox(view, p1)
                } else if (obj.result == Result.TIE) {
                    openDialogBox(view, "That was a Tie!")
                }
                if (obj.result != Result.TIE && obj.result != Result.WON) {
                    turn++
                    turn %= 2
                }
            }
        } else if (vsWhom == 1) {
            if (gameState[tappedImage] == 2 && obj.result != Result.TIE && obj.result != Result.WON && obj.result != Result.LOST) {
                gameState[tappedImage] = turn
                list.remove(tappedImage)
                if (turn == 0) {
                    img.setImageResource(R.drawable.ic_circle_secondary)
                } else if (turn == 1) {
                    img.setImageResource(R.drawable.ic_cross_yellow)
                }
                img.animate().duration = 0
                obj.isWin(
                    gameState,
                    vsWhom,
                    turn,
                    p1_winning,
                    p2_winning,
                    pl,
                    player1_trophy,
                    player2_trophy
                )
                if (obj.result == Result.WON) {
                    openDialogBox(view, "YOU")
                } else if (obj.result == Result.TIE) {
                    openDialogBox(view, "TIE")
                }
                if (obj.result != Result.TIE && obj.result != Result.WON) {
                    turn++
                    turn %= 2
                    putNew(getRandom())
                }
            }
        }
    }

    private fun getRandom(): ImageView {
        r = list[Random.nextInt(0..list.size - 1)]
        isclicked = r
        if (r == 0 && gameState[isclicked] == 2) {
            return btn1
        } else if (r == 1 && gameState[isclicked] == 2) {
            return btn2
        } else if (r == 2 && gameState[isclicked] == 2) {
            return btn3
        } else if (r == 3 && gameState[isclicked] == 2) {
            return btn4
        } else if (r == 4 && gameState[isclicked] == 2) {
            return btn5
        } else if (r == 5 && gameState[isclicked] == 2) {
            return btn6
        } else if (r == 6 && gameState[isclicked] == 2) {
            return btn7
        } else if (r == 7 && gameState[isclicked] == 2) {
            return btn8
        } else if (r == 8 && gameState[isclicked] == 2) {
            return btn9
        } else
            return getRandom()
    }

    private fun putNew(o: ImageView) {
        if (turn == 0) {
            Handler().postDelayed({
                o.setImageResource(R.drawable.ic_circle_secondary)
            }, 800)
        } else if (turn == 1) {
            Handler().postDelayed({
                o.setImageResource(R.drawable.ic_cross_yellow)
            }, 800)
        }
        gameState[isclicked] = turn
        list.remove(isclicked)
        o.animate().duration = 0
        obj.isWin(
            gameState,
            vsWhom,
            turn,
            p1_winning,
            p2_winning,
            pl,
            player1_trophy,
            player2_trophy
        )
        if (obj.result == Result.LOST) {
            openDialogBox(o, "JARVIS")
        } else if (obj.result == Result.TIE) {
            openDialogBox(o, "TIE")
        }
        if (obj.result != Result.TIE && obj.result != Result.WON) {
            turn++
            turn %= 2
        }
    }

    private fun openDialogBox(v: View, playerName: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View =
            LayoutInflater.from(v.context).inflate(R.layout.result_dialog, viewGroup, false)
        builder.setView(dialogView)
        val alertDialog: AlertDialog = builder.create()
        if (vsWhom == 0) {
            if (obj.result == Result.WON) {
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_won)
                dialogView.result.text = "Yeppii.. $playerName Won!"
            } else if (obj.result == Result.TIE) {
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_tie)
                dialogView.result.text = playerName
            }
        } else if (vsWhom == 1) {
            if (obj.result != Result.TIE) {
                if (obj.playerWon == true) {
                    dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_won)
                    dialogView.result.text = "Yeppii.. You Won!"
                } else if (obj.result == Result.LOST) {
                    dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_lost)
                    dialogView.result.text = "Ohh... You Lost!"
                }
            } else {
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_tie)
                dialogView.result.text = "That was a tie!"
            }
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
        var q = listOf<ImageView>(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        for (i: ImageView in q) {
            i.setImageResource(0)
        }
        turn = pl
        first = fl
        obj.playerWon = false
        list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8).toMutableList()
        obj.result = null
        if (vsWhom == 1) {
            if (turn != first) {
                if (turn == 0) {
                    turn = 1
                } else {
                    turn = 0
                }
                putNew(getRandom())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"
        p1 = intent.getStringExtra("Player1") ?: "Player1"
        p2 = intent.getStringExtra("Player2") ?: "Player2"
        player = intent.getIntExtra("Player", 0)
        weapon = intent.getIntExtra("Flag1", 0)
        whichFirst = intent.getIntExtra("Flag2", 0)
        whichLevel = intent.getIntExtra("Flag", 0)
        vsWhom = intent.getIntExtra("vsWhom", 2)
        if (vsWhom == 0) { // Vs Friend
            Player1.text = p1 // First Player Name
            Player2.text = p2 // Second Player Name
            if (player == 0) {
                turn = 0
                pl = 0
            } else if (player == 1) {
                turn = 1
                pl = 1
            }
        } else if (vsWhom == 1) { // Vs Jarvis
            Player1.text = "YOU"
            Player2.text = "JARVIS"
            if (whichLevel == 0 || whichLevel == 1 || whichLevel == 2) {
                if (whichFirst == 0) {
                    first = 0 // O
                    fl = 0
                } else if (whichFirst == 1) {
                    first = 1 // X
                    fl = 1
                }
                if (weapon == 0) {
                    turn = 0 // your O
                    pl = 0
                } else if (weapon == 1) {
                    turn = 1 // your X
                    pl = 1
                }
                if (turn != first) {
                    turn = if (turn == 0) {
                        1
                    } else {
                        0
                    }
                    putNew(getRandom())
                }
            }
        }
        quit.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}
