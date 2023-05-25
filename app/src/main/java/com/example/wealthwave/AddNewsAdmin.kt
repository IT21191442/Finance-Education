package com.example.wealthwave

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.wealthwave.Database.DbHelperArticles
import com.example.wealthwave.Model.ArticlesModal
import com.example.wealthwave.Model.NewsModal
import kotlinx.android.synthetic.main.activity_add_articles_admin.*
import kotlinx.android.synthetic.main.activity_add_articles_admin.articleSubmit
import kotlinx.android.synthetic.main.activity_add_news_admin.*
import java.io.ByteArrayOutputStream

class AddNewsAdmin : AppCompatActivity() {
    private val REQUEST_IMAGE_GALLERY=132
    private lateinit var imageFilePath: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news_admin)
        newsuploadImage.setOnClickListener{
            showAlertBox(this)
        }

        newsSubmit.setOnClickListener{
            var db= DbHelperArticles(this)
            if(!validation()){
                return@setOnClickListener
            }
            var newsTitle=newsType.text.toString()
            var newsDate = newsDate.text.toString()
            var newsDescription = newsDescription.text.toString()
            var newsSiteLink = newsSitelink.text.toString()

            //convert imageview to bitmap
            val bitmap = (newsuploadImage.drawable as BitmapDrawable).bitmap
            //convert bitmap to byte array
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG,90,stream)
            val byteFormat= Base64.encodeToString(stream.toByteArray(), Base64.NO_WRAP)
            val news= NewsModal(newsTitle,newsDate,newsDescription,newsSiteLink,byteFormat)

            var success=db.addNews(news)

            if(success===true){
                Toast.makeText(this,"Added Success", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Added UnSuccess", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_IMAGE_GALLERY && resultCode== Activity.RESULT_OK && data!=null){
            uploadImage.setImageURI(data.data)
            imageFilePath= data.data!!
        }
        else{
            Toast.makeText(this,"Somthing went wrong", Toast.LENGTH_LONG).show()
        }
    }

    fun showAlertBox(context: Context) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Select Image")
        builder.setMessage("Choose your Option")
        builder.setPositiveButton("Gallery"){ dialog,which->dialog.dismiss()
            val intent= Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent,REQUEST_IMAGE_GALLERY)
        }
        builder.setNegativeButton("Camera"){
                dialog,which->dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
    private fun validation():Boolean{
        if(newsType.text.isNullOrEmpty()){
            newsType.error="Please Enter the Job Name"
            return false;
        }
        if(newsDate.text.isNullOrEmpty()){
            newsDate.error="please Enter the Company name"
            return false
        }
        if(newsDescription.text.isNullOrEmpty()){
            newsDescription.error="please Enter the Company name"
            return false
        }
        if(newsSitelink.text.isNullOrEmpty()){
            newsSitelink.error="Please Enter the job Discription"
            return false
        }
        return true
    }
}