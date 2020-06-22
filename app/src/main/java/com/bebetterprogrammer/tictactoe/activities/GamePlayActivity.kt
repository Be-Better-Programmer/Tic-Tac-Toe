package com.bebetterprogrammer.tictactoe.activities

import android.app.AlertDialog
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import com.bebetterprogrammer.tictactoe.utils.GamePlayUtility
import com.bebetterprogrammer.tictactoe.utils.GetPosition
import com.bebetterprogrammer.tictactoe.utils.Result
import kotlin.properties.Delegates
import kotlinx.android.synthetic.main.activity_gameplay.*
import kotlinx.android.synthetic.main.result_dialog.view.*

class GamePlayActivity : BaseActivity() {
    var x: Int = 0
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
    var jarvis by Delegates.notNull<Int>()
    var whichFirst by Delegates.notNull<Int>()
    var whichLevel by Delegates.notNull<Int>()
    var done = 0
    var getP = GetPosition()
    var flag = false
    var played = 0
    var mFlag = false

    // 0 = O      1 = X     2 = blank
    private val obj = GamePlayUtility()
    var list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8).toMutableList()
    var isclicked = 0

    fun playerClick(view: View) {
        val img = view as ImageView
        val tappedImage = img.tag.toString().toInt()
        if (vsWhom == 0) {
            if (gameState[tappedImage] == 2 && obj.result != Result.TIE && obj.result != Result.WON) {
                gameState[tappedImage] = turn
                if (turn == 0) {
                    tv_turn.text = "$p2's Turn"
                    img.setImageResource(R.drawable.ic_circle_secondary)
                    val animFadeIn =
                        AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                    img.startAnimation(animFadeIn)
                } else if (turn == 1) {
                    tv_turn.text = "$p1's Turn"
                    img.setImageResource(R.drawable.ic_cross_yellow)
                    val animFadeIn =
                        AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                    img.startAnimation(animFadeIn)
                }
                obj.isWin(
                    gameState,
                    vsWhom,
                    turn,
                    p1_winning,
                    p2_winning,
                    -1,
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
        } else if (vsWhom == 1 && done % 2 == 1) {
            if (gameState[tappedImage] == 2 && obj.result != Result.TIE && obj.result != Result.WON && obj.result != Result.LOST && turn == weapon) {
                gameState[tappedImage] = turn
                list.remove(tappedImage)
                if (turn == weapon) {
                    tv_turn.text = "Jarvis's Turn"
                } else {
                    tv_turn.text = "Your Turn"
                }
                if (turn == 0) {
                    img.setImageResource(R.drawable.ic_circle_secondary)
                    val animFadeIn =
                        AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                    img.startAnimation(animFadeIn)
                } else if (turn == 1) {
                    img.setImageResource(R.drawable.ic_cross_yellow)
                    val animFadeIn =
                        AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                    img.startAnimation(animFadeIn)
                }
                done++
                obj.isWin(
                    gameState,
                    vsWhom,
                    turn,
                    p1_winning,
                    p2_winning,
                    weapon,
                    player1_trophy,
                    player2_trophy
                )
                if (obj.result != Result.TIE && obj.result != Result.WON) {
                    turn++
                    turn %= 2
                    putNew(getRandom())
                }
                if (obj.result == Result.WON) {
                    openDialogBox(view, "YOU")
                } else if (obj.result == Result.TIE) {
                    if (!flag) {
                        openDialogBox(view, "TIE")
                    }
                }
            }
        }
    }

    private fun getRandom(): ImageView {
        val r = getP.getPos(list, whichLevel, gameState, jarvis, weapon)
        isclicked = r
        val q = listOf<ImageView>(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        for (i: ImageView in q) {
            if (gameState[isclicked] == 2) {
                return q[isclicked]
            }
        }
        return getRandom()
    }

    private fun putNew(o: ImageView) {
        if (turn == 0) {
            Handler().postDelayed({
                tv_turn.text = "Your Turn"
                o.setImageResource(R.drawable.ic_circle_secondary)
                val animFadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                o.startAnimation(animFadeIn)
                done++
            }, 400)
        } else if (turn == 1) {
            Handler().postDelayed({
                tv_turn.text = "Your Turn"
                o.setImageResource(R.drawable.ic_cross_yellow)
                val animFadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                o.startAnimation(animFadeIn)
                done++
            }, 400)
        }
        gameState[isclicked] = turn
        list.remove(isclicked)
        obj.isWin(
            gameState,
            vsWhom,
            turn,
            p1_winning,
            p2_winning,
            weapon,
            player1_trophy,
            player2_trophy
        )
        if (obj.result == Result.LOST) {
            openDialogBox(o, "JARVIS")
        } else if (obj.result == Result.TIE) {
            flag = true
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
        val dialogView: View = LayoutInflater.from(v.context).inflate(R.layout.result_dialog, viewGroup, false)
        builder.setView(dialogView)
        val alertDialog: AlertDialog = builder.create()
        if (vsWhom == 0) {
            if (obj.result == Result.WON) {
                mFlag = true
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_won)
                dialogView.result.text = "Yeppii.. $playerName Won!"
                dialogView.animation_view.visibility = View.VISIBLE
                music(mFlag)
            } else if (obj.result == Result.TIE) {
                mFlag = true
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_tie)
                dialogView.result.text = playerName
                dialogView.animation_view.visibility = View.VISIBLE
                music(mFlag)
            }
        } else if (vsWhom == 1) {
            if (obj.result != Result.TIE) {
                if (obj.playerWon) {
                    mFlag = true
                    dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_won)
                    dialogView.result.text = "Yeppii.. You Won!"
                    dialogView.animation_view.visibility = View.VISIBLE
                    music(mFlag)
                } else if (obj.result == Result.LOST) {
                    mFlag = true
                    dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_lost)
                    dialogView.result.text = "Ohh... You Lost!"
                    music(mFlag)
                }
            } else {
                mFlag = true
                dialogView.resultTrophy.setImageResource(R.drawable.ic_trophy_tie)
                dialogView.result.text = "That was a tie!"
                dialogView.animation_view.visibility = View.VISIBLE
                music(mFlag)
            }
        }
        alertDialog.setCancelable(false)

        val animFadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.result_fade_in)
        Handler().postDelayed({
            dialogView.startAnimation(animFadeIn)
            alertDialog.show()
        }, 500)

        dialogView.btnRematch.setOnClickListener {
            val animFadeOut =
                AnimationUtils.loadAnimation(applicationContext, R.anim.result_fade_out)
            dialogView.startAnimation(animFadeOut)
            Handler().postDelayed({
                reset()
                alertDialog.dismiss()
            }, 500)
        }

        dialogView.btnQuit.setOnClickListener {
            val animFadeOut =
                AnimationUtils.loadAnimation(applicationContext, R.anim.result_fade_out)
            dialogView.startAnimation(animFadeOut)
            Handler().postDelayed({
                finish()
            }, 400)
        }
    }

    private fun music(musicFlag: Boolean){
        var winMusic = MediaPlayer.create(this@GamePlayActivity, R.raw.game_sound_single_short_generic_click_pop)
        var lostMusic = MediaPlayer.create(this@GamePlayActivity, R.raw.cartoon_pop_mouth_004)
        var tieMusic = MediaPlayer.create(this@GamePlayActivity, R.raw.game_sound_double_short_generic_click_pop_002)
        if(musicFlag == true  ) {
            if (obj.result == Result.WON) {
                mFlag = false
                Handler().postDelayed({
                    winMusic.start()
                }, 500)
            } else if (obj.result == Result.LOST) {
                mFlag = false
                Handler().postDelayed({
                    lostMusic.start()
                }, 500)
            } else {
                mFlag = false
                Handler().postDelayed({
                    tieMusic.start()
                }, 500)
            }
        } else {
            winMusic.stop()
            lostMusic.stop()
            tieMusic.stop()
        }
    }

    private fun reset() {
        flag = false
        for (i in 0..8) {
            gameState[i] = 2
        }
        var q = listOf<ImageView>(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        for (i: ImageView in q) {
            i.setImageResource(0)
        }
        player = pl
        if (x == 0) {
            turn = pl
            first = fl
        }
        obj.playerWon = false
        list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8).toMutableList()
        obj.result = null
        if (vsWhom == 1) {
            if (turn != first && played == 1) {
                first = turn
                x = 1
            }
            if (turn == first && played == 0) {
                x = 0
                first++
                first %= 2
                played = 1
            }
            if (first == turn) {
                played = 0
            }
            if (turn != first) {
                done = 0
                turn = if (turn == 0) {
                    1
                } else {
                    0
                }
                putNew(getRandom())
            } else {
                done = 1
            }
            if (turn == weapon) {
                tv_turn.text = "Your Turn"
            } else {
                tv_turn.text = "Jarvis's Turn"
            }
        } else if (vsWhom == 0) {
            if (player == 0) {
                tv_turn.text = "$p1's Turn"
            } else if (player == 1) {
                tv_turn.text = "$p2's Turn"
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
                tv_turn.text = "$p1's Turn"
                turn = 0
                pl = 1
            } else if (player == 1) {
                tv_turn.text = "$p2's Turn"
                turn = 1
                pl = 0
            }
        } else if (vsWhom == 1) { // Vs Jarvis
            played++
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
                if ((whichFirst == 0 && weapon == 0) || (whichFirst == 1 && weapon == 1)) {
                    tv_turn.text = "Your Turn"
                } else {
                    tv_turn.text = "Jarvis's Turn"
                }
                if (weapon == 0) {
                    turn = 0 // your O
                    pl = 0
                    jarvis = 1
                    done = 1
                } else if (weapon == 1) {
                    turn = 1 // your X
                    pl = 1
                    jarvis = 0
                    done = 1
                }
                if (turn != first) {
                    played = 1
                    done = 0
                    turn = if (turn == 0) {
                        1
                    } else {
                        0
                    }
                    putNew(getRandom())
                } else {
                    played = 0
                }
            }
        }
        btnQuit.setOnClickListener {
            finish()
        }
    }
}
