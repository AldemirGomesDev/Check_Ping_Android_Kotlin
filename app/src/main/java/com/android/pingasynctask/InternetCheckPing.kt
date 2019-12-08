package com.android.pingasynctask

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

internal class InternetCheckPing(private val ip: String, private val internetPingCallback: InternetPingCallback) :
    AsyncTask<Void, Void, Boolean>() {

    override fun doInBackground(vararg voids: Void): Boolean {
        return try {
            val sock = Socket()
            sock.connect(InetSocketAddress(ip, 53), 1500)
            sock.close()
            true
        } catch (e: IOException) {
            false
        }
    }

    override fun onPostExecute(internet: Boolean) {
        Log.w("ipPing", "onPostExecute")
        internetPingCallback.onSuccess(internet)
    }
}