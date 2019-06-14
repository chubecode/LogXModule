package com.chubecode.instalogger

import android.text.TextUtils
import android.util.Log
import com.chubecode.logx.DebugHelper
import com.chubecode.logx.LogLevel
import com.chubecode.logx.Logger
import java.lang.StringBuilder

/**
 * Created by ChuTien on ${1/25/2017}.
 */
class InstaLogger(appKey: String) : Logger {
    init {
        //init config
    }

    override fun sendDebugTrackingLog(e: Throwable?) {
        val debugLog = StringBuilder(DebugHelper.getInstance().loadSavedLog())
        if (e != null) {
            debugLog.append("\n ${Log.getStackTraceString(e)}")
        }
        if (!TextUtils.isEmpty(debugLog)) {
            sendLog(LogLevel.FATAL, "DebugHelper InstaLogger\n", debugLog.toString())
        }
    }

    override fun sendLog(logLevel: LogLevel, tag: String, msg: String) {
        Log.v("InstaLogger", "$tag $msg")

    }


}
