package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.net.Uri
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
            val intent = Intent(this, PlayWithJarvisActivity::class.java)
            startActivity(intent)
        }
        playWithFriend.setOnClickListener {
            val intent = Intent(this, PlayWithFriendActivity::class.java)
            startActivity(intent)
        }
        shareBtn.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=com.bebetterprogrammer.tictactoe"
            )
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
        ratingBtn.setOnClickListener {
            val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.bebetterprogrammer.tictactoe")
            val rateIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(rateIntent)
        }
    }
}
