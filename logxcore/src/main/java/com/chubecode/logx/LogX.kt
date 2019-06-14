package com.chubecode.logx

import android.util.Log


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


    private fun convertArgsToString(vararg args: Any?): String {
        var result = ""
        if (args.isNotEmpty()) {

            for (arg in args) {
                if (arg is Array<*>) {
                    arg.forEach {
                        if (it is Array<*>) {
                            result += it.joinToString("\n", ":\n")
                        } else {
                            result += it.toString()
                        }

                    }
                } else {
                    result += arg.toString()
                }
            }

        }
        return result
    }

    fun v(tag: String, msg: String, vararg args: Any?) {
        //handle arg
        val fullLog = msg.plus(convertArgsToString(args))
        Log.v(tag, fullLog)
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $fullLog}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.VERBOSE, tag, fullLog)
            }
        }


    }

    fun d(tag: String, msg: String, vararg args: Any?) {
        val fullLog = msg.plus(convertArgsToString(args))
        Log.d(tag, fullLog)
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $fullLog}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.DEBUG, tag, fullLog)
            }
        }
    }

    fun i(tag: String, msg: String, vararg args: Any?) {
        val fullLog = msg.plus(convertArgsToString(args))
        Log.i(tag, fullLog)
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $fullLog}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.INFO, tag, fullLog)
            }
        }
    }

    fun w(tag: String, msg: String, vararg args: Any?) {
        val fullLog = msg.plus(convertArgsToString(args))
        Log.w(tag, fullLog)
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $fullLog}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.WARN, tag, fullLog)
            }
        }
    }

    fun e(tag: String, msg: String, vararg args: Any?) {
        val fullLog = msg.plus(convertArgsToString(args))
        Log.e(tag, fullLog)
        if (enable) {
            DebugHelper.getInstance()
                .saveLog("$tag $fullLog}", singleLogMaxSize, totalLogMaxSize)
            loggerLists.forEach {
                it.sendLog(LogLevel.ERROR, tag, fullLog)
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


    fun setEnable(enable: Boolean) {
        this.enable = enable
    }


}