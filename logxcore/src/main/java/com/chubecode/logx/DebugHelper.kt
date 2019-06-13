package com.chubecode.logx

import android.text.TextUtils
import java.lang.StringBuilder

/**
 * Created by ChuTien on ${1/25/2017}.
 */
class DebugHelper private constructor() {
    private val stringBuilder: StringBuilder = StringBuilder()

    @Synchronized
    fun saveLog(log: String, maxSizeOfSingleLog: Int, maxSizeOfTotal: Int) {
        if (TextUtils.isEmpty(log)) return

        val modifyLog = modifyLog(log, maxSizeOfSingleLog)
        stringBuilder.append(modifyLog)

        //remove if maximum
        if (stringBuilder.length > maxSizeOfTotal) {
            stringBuilder.delete(0, stringBuilder.length - maxSizeOfTotal)
        }
    }

    fun loadSavedLog() = stringBuilder.toString()

    private fun modifyLog(log: String, maxSizeOfSingleLog: Int) = if (log.length >= maxSizeOfSingleLog) {
        "${log.substring(0, maxSizeOfSingleLog - 1)} \n"
    } else {
        "$log \n"
    }

    private object Holder {
        val INSTANCE = DebugHelper()
    }

    companion object {
        @JvmStatic
        fun getInstance(): DebugHelper {
            return Holder.INSTANCE
        }
    }
}