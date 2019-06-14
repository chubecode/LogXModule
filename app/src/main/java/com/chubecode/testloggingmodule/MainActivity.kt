package com.chubecode.testloggingmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chubecode.instalogger.InstaLogger
import com.chubecode.logx.LogX
import com.chubecode.toastlogger.ToastLogger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup logger client
        val toastLogger = ToastLogger("apiKey")
        val instaLogger = InstaLogger("apiKey")

        //set logger client
        LogX.init(
            toastLogger,
            instaLogger
        )


        log_d.setOnClickListener {
            LogX.d("Main", "Tien", "Click", "->LOG D")
        }
        log_json.setOnClickListener {

            val json = "{'a':'b','c':{'aa':234,'dd':{'az':12}}}"
            LogX.e("Main", "Json", json)

        }
        log_arr.setOnClickListener {

            val pets = arrayOf(
                Pet("Husky", 5),
                Pet("Golden", 6),
                Pet("Puppy", 7),
                Pet("Pug", 8)
            )
            LogX.v("Main", "Array", pets)

        }
        log_obj.setOnClickListener {

            val pet = Pet("Husky", 5)
            LogX.i("Main", "Object", pet)

        }
        log_debug.setOnClickListener {

            //make a ThrowableException
            LogX.sendDebugLog(Throwable(KotlinNullPointerException()))

        }


    }
}
