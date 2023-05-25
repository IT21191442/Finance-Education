package com.example.wealthwave
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.ArticlesModal
import kotlinx.android.synthetic.main.activity_add_articles_admin.*
import kotlinx.android.synthetic.main.activity_update_articles_admin.*
import kotlinx.android.synthetic.main.articleread.*
class UpdateArticlesAdmin : AppCompatActivity() {
    var article:ArticlesModal = ArticlesModal();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_articles_admin)

        //fetch data
        val value = intent.getStringExtra("id")
        val id =value!!.toInt()
        val db=DbHelperArticles(this)
        article=db.getArticles(id)
        articleTypeEdit.setText(article.article_Title)
        dateEdit.setText(article.article_Date)
        articleDescriptionEdit.setText(article.article_description)

        //update
        articleUpdate.setOnClickListener{
            var title=articleTypeEdit.text.toString()
            var date=dateEdit.text.toString()
            var discription=articleDescriptionEdit.text.toString()
            article=ArticlesModal(id,title,date,discription)
            var success=db.updateArticles(article)
            if(success == true){
                Toast.makeText(this,"Update Succesfully", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ArtcleReadAdmin::class.java))
            }else{
                Toast.makeText(this,"Update Unsuccesfully", Toast.LENGTH_LONG).show()
            }
        }
    }
}