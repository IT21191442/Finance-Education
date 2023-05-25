package com.example.wealthwave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wealthwave.Adapter.NewsUserAdapter
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.NewsModal

class NewsUserRead : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var btnadd: Button

    var Adapter: NewsUserAdapter?= null
    var DbHelp: DbHelperArticles?=null

    var newsList:List<NewsModal> = ArrayList<NewsModal>()
    var linierlayoutManager: LinearLayoutManager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_user_read)

        recyclerView = findViewById(R.id.userRecycler)
        DbHelp = DbHelperArticles(this)
        val db = DbHelperArticles(this)

        fetchlist()


    }
    private fun fetchlist(){

        newsList=DbHelp!!.getAllNews()
        Adapter= NewsUserAdapter(newsList,applicationContext);
        linierlayoutManager= LinearLayoutManager(applicationContext);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter=Adapter
        Adapter!!.notifyDataSetChanged()

    }

}