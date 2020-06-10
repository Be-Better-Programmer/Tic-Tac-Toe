package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_play_with_friend.*

class PlayWithFriendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_friend)

        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"

        var flag: Int = 0

        circle.setImageResource(R.drawable.ic_circle_secondary)

        circle.setOnClickListener(View.OnClickListener {
            cross.setImageResource(R.drawable.ic_cross_white)
            circle.setImageResource(R.drawable.ic_circle_secondary)
            flag = 0
        })

        cross.setOnClickListener(View.OnClickListener {
            circle.setImageResource(R.drawable.ic_circle_white)
            cross.setImageResource(R.drawable.ic_cross_secondary)
            flag = 1
        })

        btnPlay.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(player_one.text) || TextUtils.isEmpty(player_two.text)) {
                if (TextUtils.isEmpty(player_one.text) && TextUtils.isEmpty(player_two.text)) {
                    Toast.makeText(this, "Enter Player Name", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(player_one.text)) {
                    Toast.makeText(this, "Enter Player_1 Name", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Enter Player_2 Name", Toast.LENGTH_SHORT).show()
                }
            } else {
                val intent = Intent(this, GamePlayActivity::class.java)
                intent.putExtra("Player1", player_one.text.toString())
                intent.putExtra("Player2", player_two.text.toString())
                intent.putExtra("vsWhom", 0) // Vs Friend
                if (flag == 0) {
                    intent.putExtra("Player", 0) // O will move first
                } else if (flag == 1) {
                    intent.putExtra("Player", 1) // X will move first
                }
                startActivity(intent)
                finish()
            }
        })
        btnQuit.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}
