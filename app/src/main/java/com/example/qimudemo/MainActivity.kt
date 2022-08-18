package com.example.qimudemo


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.PermissionRequest
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.qimulibrary.QimuActivity
import com.example.qimulibrary.QimuObj


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            println(QimuObj.aa)
            println("===============")
            val intent = Intent(this, QimuActivity::class.java)
            startActivity(intent)
        }

    }

}