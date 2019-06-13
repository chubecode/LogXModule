package com.chubecode.logx

/**
 * Created by ChuTien on ${1/25/2017}.
 */
interface Logger {
    fun sendLog(logLevel: LogLevel, tag: String, msg: String, args: Array<out Any?>)
    fun sendDebugTrackingLog(e : Throwable?)
}
