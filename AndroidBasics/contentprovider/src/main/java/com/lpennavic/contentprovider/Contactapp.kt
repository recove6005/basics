package com.lpennavic.contentprovider

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Contactapp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contactapp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1) 주소록 연동
        // permission 설정 - READ_CONTACTS
        val contactBtn = findViewById<Button>(R.id.contact_btn)
        val resultView = findViewById<TextView>(R.id.result_view)
        val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            val cursor = contentResolver.query(
                it.data!!.data!!,
                arrayOf(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER),
                null,
                null,
                null
            )
            var name = "none"
            var phone = "none"
            if(cursor!!.moveToNext()) {
                name = cursor?.getString(0).toString()
                phone = cursor?.getString(1).toString()
            }
            resultView.text = "name - $name, phone - $phone"
        }

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if(isGranted) {
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                requestActivity.launch(intent)
            }
        }

        contactBtn.setOnClickListener {
            // 버튼을 누르면 퍼미션 체크
            val status = ContextCompat.checkSelfPermission(this, "android.permission.READ_CONTACTS")
            if(status == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                requestActivity.launch(intent)
            } else {
                // 퍼미션이 없으면 퍼미션 요청
                permissionLauncher.launch("android.permisson.READ_CONTACTS")
            }
        }

    }
}