package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button3.setOnClickListener{
            startActivity(Intent(this,FinanceAdmin::class.java))
        }
        /*button5.setOnClickListener{
            startActivity(Intent(this,NewsUserRead::class.java))
        }
        buttonUserreadArticle.setOnClickListener{
            startActivity(Intent(this,ArticleUserRead::class.java))
        }*/
        userread.setOnClickListener{
            startActivity(Intent(this,ArticleUserMain::class.java))
        }

    }
}