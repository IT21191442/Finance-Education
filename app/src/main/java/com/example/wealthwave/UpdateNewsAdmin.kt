package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.NewsModal
import kotlinx.android.synthetic.main.activity_news_read_admin.*
import kotlinx.android.synthetic.main.activity_update_news_admin.*

class UpdateNewsAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_news_admin)
//fetch data
        val value = intent.getStringExtra("id")
        val id =value!!.toInt()
        val db= DbHelperArticles(this)
        var news=NewsModal()
        news=db.getNews(id)

        newsTypeEdit.setText(news.news_Title).toString()
        newsdateEdit.setText(news.news_Date).toString()
        newsDescriptionEdit.setText(news.news_description).toString()
        newsSitelinkEdit.setText(news.news_sitelink).toString()

        //update
        updatenewsbtn.setOnClickListener{

            var newstitle=newsTypeEdit.text.toString()
            var newsdate=newsdateEdit.text.toString()
            var newsdiscription=newsDescriptionEdit.text.toString()
            var newssitelink=newsSitelinkEdit.text.toString()

            news= NewsModal(id,newstitle,newsdate,newsdiscription,newssitelink)
            var success=db.updateNews(news)
            if(success == true){
                Toast.makeText(this,"Update Succesfully", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,NewsReadAdmin::class.java))
            }else{
                Toast.makeText(this,"Update Unsuccesfully", Toast.LENGTH_LONG).show()
            }
        }
    }
}