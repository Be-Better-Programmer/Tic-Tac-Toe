package com.bebetterprogrammer.tictactoe.utils

import android.widget.ImageView
import android.widget.TextView
import com.bebetterprogrammer.tictactoe.R

class GamePlayUtility {
    var winPosition = arrayOf(
        arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), arrayOf(0, 3, 6),
        arrayOf(1, 4, 7), arrayOf(2, 5, 8), arrayOf(0, 4, 8), arrayOf(2, 4, 6)
    )
    var p1 = 0
    var p2 = 0
    var playerWon = false
    var result: Result? = null
    fun isWin(
        gameState: Array<Int>,
        vsWhom: Int,
        turn: Int,
        p1_winning: TextView,
        p2_winning: TextView,
        pl: Int,
        player1_trophy: ImageView,
        player2_trophy: ImageView
    ) {
        for (winPosition in winPosition) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                if (vsWhom == 0) { // Vs Friend
                    if (turn == 0) {
                        result = Result.WON
                        p1 = p1_winning.text.toString().toInt()
                        p1++
                        p1_winning.text = p1.toString()
                    } else {
                        result = Result.WON
                        p2 = p2_winning.text.toString().toInt()
                        p2++
                        p2_winning.text = p2.toString()
                    }
                } else if (vsWhom == 1) { // Vs Jarvis
                    if (turn == pl) {
                        result = Result.WON
                        playerWon = true
                        p1 = p1_winning.text.toString().toInt()
                        p1++
                        p1_winning.text = p1.toString()
                    } else {
                        result = Result.LOST
                        p2 = p2_winning.text.toString().toInt()
                        p2++
                        p2_winning.text = p2.toString()
                    }
                }
                when {
                    p1 > p2 -> {
                        player1_trophy.setImageResource(R.drawable.ic_trophy_golden)
                        player2_trophy.setImageResource(R.drawable.ic_trophy_grey)
                    }
                    p2 > p1 -> {
                        player2_trophy.setImageResource(R.drawable.ic_trophy_golden)
                        player1_trophy.setImageResource(R.drawable.ic_trophy_grey)
                    }
                    else -> {
                        player2_trophy.setImageResource(R.drawable.ic_trophy_grey)
                        player1_trophy.setImageResource(R.drawable.ic_trophy_grey)
                    }
                }
            }
        }
        for (i in 0..8) {
            if (gameState[i] != 2 && (result != Result.WON && result != Result.LOST)) {
                result = Result.TIE
            } else {
                if (result != Result.LOST && result != Result.WON) {
                    result = null
                    break
                }
            }
        }
    }
}
