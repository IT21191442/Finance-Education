package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wealthwave.Adapter.ArticleAdminAdapter
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.ArticlesModal
import kotlinx.android.synthetic.main.activity_artcle_read_admin.*

class ArtcleReadAdmin : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var btnadd: Button
    var Adapter:ArticleAdminAdapter ?= null
    var DbHelp:DbHelperArticles ?=null
    var articleList:List<ArticlesModal> = ArrayList<ArticlesModal>()
    var linierlayoutManager: LinearLayoutManager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artcle_read_admin)
        recyclerView = findViewById(R.id.recyclerView)
        DbHelp = DbHelperArticles(this)
        val db = DbHelperArticles(this)
        fetchlist()
        var deleteBtn=findViewById<Button>(R.id.deletebtn)
        var addArticlebtn=findViewById<Button>(R.id.addArticle)
        addArticlebtn.setOnClickListener{
            startActivity(Intent(this,AddArticlesAdmin::class.java))
        }
        deleteBtn.setOnClickListener{
            var id = editNumber.text.toString()
            println(id)
            val iD = id.toInt()//Casting
            val success = db.deleteArticle(iD)
            println(iD)
            if (success == true){
                Toast.makeText(this,"Delete Successfully",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ArtcleReadAdmin::class.java))
            }else{
                Toast.makeText(this,"Delete Unsuccessfully",Toast.LENGTH_LONG).show()
            }
        }
        updatebtn.setOnClickListener{
            var id = editNumber.text.toString()
            println(id)
            val intent = Intent(this, UpdateArticlesAdmin::class.java)
            intent.putExtra("id", id)//bind the Id value and send update page
            startActivity(intent)
        }
    }
    private fun fetchlist(){
        articleList=DbHelp!!.getAllArtcles()
        Adapter= ArticleAdminAdapter(articleList,applicationContext);
        linierlayoutManager= LinearLayoutManager(applicationContext);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter=Adapter
        Adapter!!.notifyDataSetChanged()
    }
}