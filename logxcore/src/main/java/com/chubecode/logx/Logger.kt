package com.chubecode.logx

/**
 * Created by ChuTien on ${1/25/2017}.
 */
interface Logger {
    fun sendLog(logLevel: LogLevel, tag: String, msg: String)
    fun sendDebugTrackingLog(e : Throwable?)
}
