package com.bebetterprogrammer.tictactoe.activities

import android.view.View
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_gameplay.*

class Iswin {
    var winPosition = arrayOf(
        arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), arrayOf(0, 3, 6),
        arrayOf(1, 4, 7), arrayOf(2, 5, 8), arrayOf(0, 4, 8), arrayOf(2, 4, 6)
    )
    var p1 = 0
    var p2 = 0

    fun iswin(ob: GamePlayActivity): Boolean {
        var x = false
        for (winPosition in winPosition) {
            if (ob.gameState[winPosition[0]] == ob.gameState[winPosition[1]] && ob.gameState[winPosition[1]] == ob.gameState[winPosition[2]] && ob.gameState[winPosition[0]] != 2) {
                // won
                if (ob.turn == 0) {
                    if (ob.won == 0) {
                        ob.won = 1
                        p1 = ob.p1_winning.text.toString().toInt()
                        p1++
                        ob.p1_winning.text = p1.toString()
                    }
                } else {
                    if (ob.won == 0) {
                        ob.won = 1
                        p2 = ob.p2_winning.text.toString().toInt()
                        p2++
                        ob.p2_winning.text = p2.toString()
                    }
                }
                if (p1 > p2) {
                    ob.player1_trophy.setImageResource(R.drawable.ic_trophy_golden)
                    ob.player2_trophy.setImageResource(R.drawable.ic_trophy_grey)
                } else if (p2 > p1) {
                    ob.player2_trophy.setImageResource(R.drawable.ic_trophy_golden)
                    ob.player1_trophy.setImageResource(R.drawable.ic_trophy_grey)
                } else {
                    ob.player2_trophy.setImageResource(R.drawable.ic_trophy_grey)
                    ob.player1_trophy.setImageResource(R.drawable.ic_trophy_grey)
                }
                x = true
            }
        }
        return x
    }

    fun isTie(ob: GamePlayActivity): Boolean {
        for (i in 0..8) {
            if (ob.gameState[i] == 2) {
                return false
            }
            if (ob.won == 1) {
                return false
            }
        }
        return true
    }
}
