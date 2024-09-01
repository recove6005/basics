package com.lpennavic.contentprovider

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Callapp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_callapp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // CALL_PHONE 퍼미션 필요
        // 인텐트 액션 문자열을 Intent.ACTION_CALL 로 지정
        // data 정보의 URL은 tel: 으로 선언
        // data 정보로 전화번호 명시

        val edit = findViewById<EditText>(R.id.edit)
        val btn = findViewById<Button>(R.id.btn)

        val permissonLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if(isGranted) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${edit.text}"))
                startActivity(intent)
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
            }
        }

        btn.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE")
            // 퍼미션 확인
            if(status == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${edit.text}"))
                startActivity(intent)
            } else {
                // 퍼미션이 허용되지 않으면 퍼미션 요청
                permissonLauncher.launch("android.permission.CALL_PHONE")
            }
        }



    }
}