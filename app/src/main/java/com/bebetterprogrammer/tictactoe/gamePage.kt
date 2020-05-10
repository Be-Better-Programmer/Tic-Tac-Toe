package com.bebetterprogrammer.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_page.*

class gamePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)
        var choose = 0
        Obtn.setOnClickListener{
            //O clicked
             choose = 1
            //startActivity(intent)

        }
        Xbtn.setOnClickListener{
            //Xclicked
             choose = 2
            //startActivity(intent)

        }


        play.setOnClickListener {
            val p1 = player1.text.toString()
            val p2 = player2.text.toString()
            val intent = Intent(this, Gameplay::class.java)
            intent.putExtra("Player",choose.toString())
            intent.putExtra("Player1",p1)
            intent.putExtra("Player2",p2)

            startActivity(intent)
        }

    }
}
