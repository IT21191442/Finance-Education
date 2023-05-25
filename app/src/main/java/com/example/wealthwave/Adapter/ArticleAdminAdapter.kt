package com.example.wealthwave.Adapter

import  android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wealthwave.Model.ArticlesModal
import com.example.wealthwave.R
import java.io.ByteArrayInputStream
import kotlin.collections.ArrayList

class ArticleAdminAdapter(ArticlesModal:List<ArticlesModal>,internal var context: Context): RecyclerView.Adapter<ArticleAdminAdapter.ArticlesViewHolder>() {

    internal var articleList:List<ArticlesModal> = ArrayList()
    init{

        this.articleList=ArticlesModal;

    }

    inner class ArticlesViewHolder(view: View): RecyclerView.ViewHolder(view){

        var ArticleId: TextView =view.findViewById(R.id.articleId)
        var ArticleTitle: TextView =view.findViewById(R.id.articleTitle)
        var ArticleDate: TextView =view.findViewById(R.id.articleDate)
        var ArticleDescripion: TextView =view.findViewById(R.id.articleDescription)
        var image: ImageView =view.findViewById(R.id.readImage)


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {

        val view= LayoutInflater.from(context).inflate(R.layout.articleread,parent,false)

        return ArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {

        val articles=articleList[position]

        holder.ArticleId.text=articles.article_Id.toString()
        holder.ArticleTitle.text=articles.article_Title
        holder.ArticleDate.text=articles.article_Date
        holder.ArticleDescripion.text=articles.article_description;



        // Example base64-encoded byte code string
        val byteCodeString = articles.article_Image

// Decode the byte code string into a byte array
        val imageBytes = Base64.decode(byteCodeString, Base64.DEFAULT)

// Create a new bitmap object
        val imageBitmap = BitmapFactory.decodeStream(ByteArrayInputStream(imageBytes))


        //println(users.email);
        // println(users.image);

        holder.image.setImageBitmap(imageBitmap);


    }
    override fun getItemCount(): Int {

        println(articleList.size);
        println("heloooooooooooooooooo")
        return articleList.size;

    }
}