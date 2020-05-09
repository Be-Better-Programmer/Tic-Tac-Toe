package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_home_page.*


class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        playWithJarvis.setOnClickListener {

//            val i = Intent(this, PlayWithFriendActivity::class.java)
//            startActivity(i)

            val toast = Toast.makeText(
                applicationContext,
                "Play with JARVIS😀",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
        playWithFriend.setOnClickListener {

            val i = Intent(this, PlayWithFriendActivity::class.java)
            startActivity(i)

            val toast = Toast.makeText(
                applicationContext,
                "Play with Your FRIEND😀",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}
