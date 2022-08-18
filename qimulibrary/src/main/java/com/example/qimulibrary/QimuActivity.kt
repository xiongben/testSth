package com.example.qimulibrary

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class QimuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(this@QimuActivity, arrayOf(Manifest.permission.CAMERA),1010)
        setContentView(R.layout.activity_qimu)
        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true;
        webView.settings.defaultTextEncodingName = "UTF-8";
        webView.settings.allowContentAccess = true; // 是否可访问Content Provider的资源，默认值 true
        webView.settings.allowFileAccess = true;
        webView.settings.allowContentAccess = true
//        webView.settings.mediaPlaybackRequiresUserGesture = false

        webView.webChromeClient = object : WebChromeClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onPermissionRequest(request: PermissionRequest?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request!!.grant(request.resources)
                }
            }

        }

        webView.webViewClient = object : WebViewClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
                if (request != null) {
                    if (request.url.toString().contains("liveness.skytouch.cc")) {
                        Log.d("QimuActivity", request.url.toString())
                    }
                }
                return super.shouldInterceptRequest(view, request)
            }
        }



        webView.loadUrl("https://liveness.zanatest.com/#/kyc-about")
    }


}



