package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_article_admin_main.*

class ArticleAdminMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_admin_main)


        articlepagebtn.setOnClickListener{
            startActivity(Intent(this,ArtcleReadAdmin::class.java))
        }

       newsepagebtn.setOnClickListener{
            startActivity(Intent(this,NewsReadAdmin::class.java))
        }
    }
}