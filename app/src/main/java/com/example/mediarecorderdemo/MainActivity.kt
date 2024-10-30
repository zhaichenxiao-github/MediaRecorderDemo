package com.example.mediarecorderdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.exoplayer.ExoPlayer
import com.luozm.captcha.Captcha

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val captcha = findViewById<Captcha>(R.id.captCha);
//        captcha.setBitmap("http://img4.imgtn.bdimg.com/it/u=2091068830,1003707060&fm=200&gp=0.jpg")
        captcha.setCaptchaListener(object : Captcha.CaptchaListener {
            override fun onAccess(time: Long): String {
                Toast.makeText(this@MainActivity, "验证成功", Toast.LENGTH_SHORT).show()
                return ""
            }

            override fun onFailed(failCount: Int): String {
                Toast.makeText(this@MainActivity, "验证失败", Toast.LENGTH_SHORT).show()
                return ""
            }

            override fun onMaxFailed(): String {
                Toast.makeText(
                    this@MainActivity,
                    "验证超过次数，你的帐号被封锁",
                    Toast.LENGTH_SHORT
                )
                    .show();
                return ""
            }

        })
    }
}