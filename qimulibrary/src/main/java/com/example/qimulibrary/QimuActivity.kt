package com.example.qimulibrary

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class QimuActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qimu)
        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true

        webView.settings.domStorageEnabled = true;
        webView.settings.defaultTextEncodingName = "UTF-8";
        webView.settings.allowContentAccess = true; // 是否可访问Content Provider的资源，默认值 true
        webView.settings.allowFileAccess = true;
        webView.settings.allowContentAccess = true
        webView.settings.mediaPlaybackRequiresUserGesture = false



        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                // WebView加载该Url
                return false
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onPermissionRequest(request: PermissionRequest?) {
                super.onPermissionRequest(request)
                val requestedResources = request?.resources
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    request?.grant(requestedResources)
//                }
                if (requestedResources != null) {
                    for (r in requestedResources) {
                        Log.d("My Request", "onPermissionRequest: " + r)
                        request.grant(arrayOf(r))
                        if (r == PermissionRequest.RESOURCE_VIDEO_CAPTURE) {
                            Log.d("My Request", "onPermissionRequest: " + requestedResources)
                            request.grant(arrayOf(PermissionRequest.RESOURCE_VIDEO_CAPTURE))
                            break
                        }
                    }
                }
                this@QimuActivity.runOnUiThread(Runnable {
                    Log.d(TAG, request!!.origin.toString())
                    if (request!!.origin.toString().equals("file:///")) {
                        Log.d(TAG, "GRANTED")
                        request!!.grant(request!!.resources)
                    } else {
                        Log.d(TAG, "DENIED")
                        request!!.deny()
                    }
                })
            }

            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                println(fileChooserParams)
                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
            }


        }


//        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://liveness.zanatest.com/#/test-page")
    }


}



