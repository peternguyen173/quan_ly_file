package com.example.calculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class FileContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_content)

        val filePath = intent.getStringExtra(EXTRA_FILE_PATH) ?: return
        val file = File(filePath)

        val contentTextView: TextView = findViewById(R.id.contentTextView)
        if (file.exists() && file.isFile) {
            contentTextView.text = file.readText()
        } else {
            contentTextView.text = "Không thể đọc nội dung file!"
        }
    }

    companion object {
        private const val EXTRA_FILE_PATH = "file_path"

        fun start(context: Context, file: File) {
            val intent = Intent(context, FileContentActivity::class.java)
            intent.putExtra(EXTRA_FILE_PATH, file.absolutePath)
            context.startActivity(intent)
        }
    }
}
