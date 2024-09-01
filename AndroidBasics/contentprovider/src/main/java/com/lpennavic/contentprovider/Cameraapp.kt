package com.lpennavic.contentprovider

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import javax.annotation.processing.Generated

class Cameraapp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cameraapp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. 사진 데이터만 획득하는 방법
        //  - 카메라로 찍은 사진 데이터를 저장하지 않고 바로 넘겨받음
        //  - 사이즈가 본래의 카메라 성능보다 작음
        // 인텐트 액션 문자열 ACTION_IMAGE_CAPTURE
        // requestActivity.launch(intent)
        // val bitmap = it.data?.getExtra()?.get("data") as Bitmap

        // 2. 파일을 공유하는 방법
        //  - 사진 촬영 후 해당 사진을 파일로 저장함 - 카메라 성능에 맞게 풀데이터를 저장함
        //  - 결과를 성공 실패로만 전달 받음
        //   1) 앱에서 저장할 파일을 만듦
        //   2) 인텐트를 발생시켜 카메라 앱 실행
        //   3) 사진 촬영후 사진을 공유된 파일에 저장
        //   4) 카메라 앱이 종료되면 성공 실패 결과값을 반환
        //   5) 앱에서 파일을 읽어들여 카메라 앱이 저장한 사진 파일을 가져와 bitmap으로 decode
        //  - 앱과 앱간의 파일 공유 시 세팅 필요
        //  -> xml 파일 생성 및 Menifast 파일에 등록 : FileProvider

        val img = findViewById<ImageView>(R.id.img)
        val dataBtn = findViewById<Button>(R.id.databtn)
        val fileBtn = findViewById<Button>(R.id.filebtn)

        // 사진 데이터만 가져오기
        val launcher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val bitmap = it.data?.extras?.get("data") as Bitmap
            bitmap?.let {
                img.setImageBitmap(bitmap)
            }
        }

        dataBtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher.launch(intent)
        }


        // 사진 데이터를 파일로 저장 후 가져오기
        var filePath = ""
        val fileLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val option = BitmapFactory.Options()
            option.inSampleSize = 3
            val bitmap = BitmapFactory.decodeFile(filePath, option)
            bitmap?.let {
                img.setImageBitmap(bitmap)
            }
        }

        fileBtn.setOnClickListener {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())

            val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            // Environment.DIRECTORY_PICTURES는 Android 운영체제에서 이미지 파일을 저장하기 위해 권장하는 표준 디렉토리
            // 일반적으로 /storage/emulated/0/Pictures/ 경로에 해당함

            val file = File.createTempFile(
                "JPEG_${timeStamp}_", // 파일 이름
                ".jpg", // 파일 확장자
                storageDir // 파일 저장 디렉터리
            )
            filePath = file.absolutePath
            Log.v("filepath", "Generated file path: $filePath")

            val uri = FileProvider.getUriForFile(
                this,
                "com.lpennavic.contentprovider.fileprovider",
                file
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            fileLauncher.launch(intent)
        }



    }
}