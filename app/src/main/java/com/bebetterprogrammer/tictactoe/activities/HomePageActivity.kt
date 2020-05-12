package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_home_page.*


class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | $versionName"


        playWithJarvis.setOnClickListener {

//            // Initialize a new layout inflater instance
//            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//
//            // Inflate a custom view using layout inflater
//            val view = inflater.inflate(R.layout.dialog_result,null)
//
//            // Initialize a new instance of popup window
//            val popupWindow = PopupWindow(
//                view, // Custom view to show in popup window
//                ConstraintLayout.LayoutParams.WRAP_CONTENT,
//                ConstraintLayout.LayoutParams.WRAP_CONTENT
//
//            )
//
////            val buttonPopup = view.findViewById<Button>(R.id.quit_match)
////
////            // Set a click listener for popup's button widget
////            buttonPopup.setOnClickListener{
////                // Dismiss the popup window
////                popupWindow.dismiss()
////            }
//
//            // Finally, show the popup window on app
//            TransitionManager.beginDelayedTransition(homePage)
//            popupWindow.showAtLocation(
//                homePage, // Location to display popup window
//                Gravity.CENTER, // Exact position of layout to display popup
//                0, // X offset
//                0 // Y offset
//            )


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
