package com.chubecode.testloggingmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chubecode.instalogger.InstaLogger
import com.chubecode.logx.LogX
import com.chubecode.logx.Logger
import com.chubecode.toastlogger.ToastLogger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastLogger = ToastLogger("apiKey")
        val instaLogger = InstaLogger("apiKey")
        LogX.init(
            toastLogger,
            instaLogger,
            enable = true
        )

        log_d.setOnClickListener {
            LogX.d("Main", "Tien", "Click", "->LOG D")
        }
        log_e.setOnClickListener {
            LogX.d("Main", "Tien", "Click", "->LOG E")
        }
        log_v.setOnClickListener {
            LogX.d("Main", "Tien", "Click", "->LOG V")
        }
        log_i.setOnClickListener {
            LogX.d("Main", "Tien", "Click", "->LOG I")
        }
        log_debug.setOnClickListener {
            //make a ThrowableException
            LogX.sendDebugLog(Throwable(KotlinNullPointerException()))
        }


    }
}
