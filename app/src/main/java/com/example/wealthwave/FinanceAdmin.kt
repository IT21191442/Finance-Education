package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finance_admin.*
import kotlinx.android.synthetic.main.activity_main.*

class FinanceAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_admin)


        job.setOnClickListener{
            startActivity(Intent(this,FinanceAdmin::class.java))
        }

        education.setOnClickListener{
            startActivity(Intent(this,ArticleAdminMain::class.java))
        }
    }
}