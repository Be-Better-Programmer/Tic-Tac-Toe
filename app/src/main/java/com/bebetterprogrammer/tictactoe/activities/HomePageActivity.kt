package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"

        playWithJarvis.setOnClickListener {
            val i1 = Intent(this, PlayWithJarvisActivity::class.java)
            startActivity(i1)
        }
        playWithFriend.setOnClickListener {
            val i = Intent(this, PlayWithFriendActivity::class.java)
            startActivity(i)
        }
    }
}
