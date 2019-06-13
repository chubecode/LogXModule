package com.chubecode.logx

import android.util.Log
import java.lang.NullPointerException

/**
 * Created by ChuTien on ${1/25/2017}.
 */
object LogX {

    private val loggerLists: MutableList<Logger> = ArrayList()

    private var enable: Boolean = true

    private var singleLogMaxSize: Int = 0

    private var totalLogMaxSize: Int = 0

    fun init(vararg loggers: Logger, enable: Boolean = true, singleLogSize: Int = 1000, totalLogSize: Int = 10000) {
        for (logger in loggers) {
            loggerLists.add(logger)
        }
        this.enable = enable
        this.singleLogMaxSize = singleLogSize
        this.totalLogMaxSize = totalLogSize

    }

    fun v(tag: String, msg: String, vararg args: Any?) {
        Log.v(tag, msg.plus(args.joinToString(":", ":")))
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $msg ${args.joinToString(":", ":")}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.VERBOSE, tag, msg, args)
            }
        }


    }

    fun d(tag: String, msg: String, vararg args: Any?) {
        Log.d(tag, msg.plus(args.joinToString(":", ":")))
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $msg ${args.joinToString(":", ":")}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.DEBUG, tag, msg, args)
            }
        }
    }

    fun i(tag: String, msg: String, vararg args: Any?) {
        Log.i(tag, msg.plus(args.joinToString(":", ":")))
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $msg ${args.joinToString(":", ":")}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.INFO, tag, msg, args)
            }
        }
    }

    fun w(tag: String, msg: String, vararg args: Any?) {
        Log.w(tag, msg.plus(args.joinToString(":", ":")))
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $msg ${args.joinToString(":", ":")}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.WARN, tag, msg, args)
            }
        }
    }

    fun e(tag: String, msg: String, vararg args: Any?) {
        Log.e(tag, msg.plus(args.joinToString(":", ":")))
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $msg ${args.joinToString(":", ":")}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.ERROR, tag, msg, args)
            }
        }
    }

    fun sendDebugLog(e: Throwable?) {
        if (enable) {
            loggerLists.forEach {
                it.sendDebugTrackingLog(e)
            }
        }
    }


}