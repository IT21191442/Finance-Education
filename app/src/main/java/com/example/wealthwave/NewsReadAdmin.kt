package com.example.wealthwave

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wealthwave.Adapter.NewsAdminAdapter
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.NewsModal
import kotlinx.android.synthetic.main.activity_news_read_admin.*
class NewsReadAdmin : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var btnadd: Button
    var Adapter: NewsAdminAdapter?= null
    var DbHelp: DbHelperArticles?=null

    var newsList:List<NewsModal> = ArrayList<NewsModal>()
    var linierlayoutManager: LinearLayoutManager?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_read_admin)
        recyclerView = findViewById(R.id.recyclerView)
        DbHelp = DbHelperArticles(this)
        val db = DbHelperArticles(this)
        fetchlist()

        var deleteNewsBtn=findViewById<Button>(R.id.deletenewsbtn)
        var addNewsbtn=findViewById<Button>(R.id.addNews)

        addNewsbtn.setOnClickListener{
            startActivity(Intent(this,AddNewsAdmin::class.java))
        }
        deleteNewsBtn.setOnClickListener{
            var id = editNumber.text.toString()
            println(id)
            val iD = id.toInt()//Casting
            val success = db.deleteNews(iD)
            println(iD)
            if (success == true){
                Toast.makeText(this,"Delete Successfully", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ArtcleReadAdmin::class.java))
            }else{
                Toast.makeText(this,"Delete Unsuccessfully", Toast.LENGTH_LONG).show()
            }
        }
        updatenewsBtn.setOnClickListener{
            var id = editNumber.text.toString()
            println(id)
            val intent = Intent(this, UpdateNewsAdmin::class.java)
            intent.putExtra("id", id)//bind the Id value and send update page
            startActivity(intent)
        }

    }
    private fun fetchlist(){

        newsList=DbHelp!!.getAllNews()
        Adapter= NewsAdminAdapter(newsList,applicationContext);
        linierlayoutManager= LinearLayoutManager(applicationContext);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter=Adapter
        Adapter!!.notifyDataSetChanged()

    }
}