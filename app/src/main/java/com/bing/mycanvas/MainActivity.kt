package com.bing.mycanvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var canvas: MyCanvas
    lateinit var clearBtn : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clearBtn = findViewById(R.id.btn_clear)
        canvas = findViewById(R.id.canvas)

        clearBtn.setOnClickListener {
            //重置画板
            canvas.clear()
        }
    }
}