package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_article_admin_main.*
import kotlinx.android.synthetic.main.activity_article_user_main.*

class ArticleUserMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_user_main)

        articleuserpagebtn.setOnClickListener{
            startActivity(Intent(this,ArticleUserRead::class.java))
        }

        newsuserpagebtn.setOnClickListener{
            startActivity(Intent(this,NewsUserRead::class.java))
        }
    }
}