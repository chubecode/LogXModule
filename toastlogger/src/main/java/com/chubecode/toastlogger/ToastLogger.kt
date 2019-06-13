package com.chubecode.toastlogger

import android.text.TextUtils
import android.util.Log
import com.chubecode.logx.DebugHelper
import com.chubecode.logx.LogLevel
import com.chubecode.logx.Logger
import com.toast.android.logger.LogEntry
import com.toast.android.logger.ToastLogger
import com.toast.android.logger.ToastLoggerConfiguration
import java.lang.StringBuilder

/**
 * Created by ChuTien on ${1/25/2017}.
 */
class ToastLogger : Logger {
    override fun sendDebugTrackingLog(e: Throwable?) {
        val debugLog = StringBuilder(DebugHelper.getInstance().loadSavedLog())
        if (e != null) {
            debugLog.append("\n ${Log.getStackTraceString(e)}")
        }
        if (!TextUtils.isEmpty(debugLog)) {
            sendLog(LogLevel.FATAL, "DebugHelper - ToastLogger\n", debugLog.toString())
        }
    }

    constructor(appKey: String) {
        val configuration = ToastLoggerConfiguration.newBuilder()
            .setAppKey(appKey)
            .build()
        ToastLogger.initialize(configuration)
    }

    override fun sendLog(logLevel: LogLevel, tag: String, msg: String, vararg args: Any?) {
        var toastLogLevel: com.toast.android.logger.LogLevel = com.toast.android.logger.LogLevel.NONE
        when (logLevel) {
            LogLevel.VERBOSE, LogLevel.DEBUG -> {
                toastLogLevel = com.toast.android.logger.LogLevel.DEBUG
            }
            LogLevel.INFO -> {
                toastLogLevel = com.toast.android.logger.LogLevel.INFO
            }
            LogLevel.WARN -> {
                toastLogLevel = com.toast.android.logger.LogLevel.WARN
            }
            LogLevel.ERROR -> {
                toastLogLevel = com.toast.android.logger.LogLevel.ERROR
            }
            else -> {
                toastLogLevel = com.toast.android.logger.LogLevel.FATAL
            }

        }
        val logEntry = LogEntry.newBuilder()
            .setLogLevel(toastLogLevel)
            .setLogMessage("$tag $msg ${args.joinToString(":", ":")}")
            .setLogType("LOG")
            .build()
        ToastLogger.log(logEntry)
        Log.d("ToastLogger", "$tag $msg ${args.joinToString(":", ":")}")
    }


}