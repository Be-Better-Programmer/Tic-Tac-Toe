package com.bebetterprogrammer.tictactoe.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.bebetterprogrammer.tictactoe.R

class PlayWithFriendActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_friend)
            var flag:Int = 0
            val p1=findViewById<EditText>(R.id.player_one)
            val p2=findViewById<EditText>(R.id.player_two)
            val btnPlay=findViewById<Button>(R.id.play)
            val circle=findViewById<ImageButton>(R.id.circle)
            circle.setOnClickListener(View.OnClickListener {
                flag=0
            })

            val cross=findViewById<ImageButton>(R.id.cross)
            cross.setOnClickListener(View.OnClickListener {
                flag=1
            })

            btnPlay.setOnClickListener(View.OnClickListener {
                if(TextUtils.isEmpty(p1.text)||TextUtils.isEmpty(p2.text)){
                    if(TextUtils.isEmpty(p1.text)&&TextUtils.isEmpty(p2.text)){
                        Toast.makeText(
                            this@PlayWithFriendActivity,
                            "Enter Player Name",
                            Toast.LENGTH_SHORT).show()
                    }else if(TextUtils.isEmpty(p1.text)){
                        Toast.makeText(
                            this@PlayWithFriendActivity,
                            "Enter Player_1 Name",
                            Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(
                            this@PlayWithFriendActivity,
                            "Enter Player_2 Name",
                            Toast.LENGTH_SHORT).show()
                    }
                }else{
                    if(flag==0){
                        Toast.makeText(
                            this@PlayWithFriendActivity,
                            " "+p1.text+" Move First",
                            Toast.LENGTH_SHORT).show()
//                        var intent = Intent(this, Dummyactivity::class.java)
//                        intent.putExtra("playername",p1.text.toString())
//                        startActivity(intent)
//                        finish()
                    }else if(flag==1){
                        Toast.makeText(
                            this@PlayWithFriendActivity,
                            " "+p2.text+" Move First",
                            Toast.LENGTH_SHORT).show()
//                        var intent = Intent(this, Dummyactivity::class.java)
//                        intent.putExtra("playername",p2.text.toString())
//                        startActivity(intent)
//                        finish()
                    }
                }
            })

            var btnQuit=findViewById(R.id.quit) as Button
            btnQuit.setOnClickListener(View.OnClickListener {
                finish()
            })
        }
}
