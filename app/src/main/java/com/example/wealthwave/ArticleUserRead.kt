package com.example.wealthwave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wealthwave.Adapter.ArtcleUserAdapter
import com.example.wealthwave.Adapter.ArticleAdminAdapter
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.ArticlesModal
import kotlinx.android.synthetic.main.activity_article_user_read.*

class ArticleUserRead : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var btnadd: Button

    var Adapter: ArtcleUserAdapter?= null
    var DbHelp: DbHelperArticles?=null

    var articleList:List<ArticlesModal> = ArrayList<ArticlesModal>()
    var linierlayoutManager: LinearLayoutManager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_user_read)

        recyclerView = findViewById(R.id.userRecycler)
        DbHelp = DbHelperArticles(this)
        val db = DbHelperArticles(this)

        fetchlist()


    }

    private fun fetchlist(){

        articleList=DbHelp!!.getAllArtcles()
        Adapter= ArtcleUserAdapter(articleList,applicationContext);
        linierlayoutManager= LinearLayoutManager(applicationContext);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter=Adapter
        Adapter!!.notifyDataSetChanged()

    }
}