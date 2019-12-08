package com.android.pingasynctask

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private var TAG: String = "testePing"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testePing.setOnClickListener {

            val ip = edtIP.text.toString()
            tvResult.text = "carregando..."
            InternetCheckPing(ip, object : InternetPingCallback {
                override fun onSuccess(isPing: Boolean) {
                    Log.w(TAG, "onSuccess: $isPing")
                    Thread.sleep(5000)
                    tvResult.text = "Ping: $isPing"
                }

            }).execute()
        }
    }
}
