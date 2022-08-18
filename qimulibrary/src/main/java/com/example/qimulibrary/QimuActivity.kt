package com.example.qimulibrary

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream


class QimuActivity : AppCompatActivity() {

//    var sourceStrArr = arrayOf(
//        "ssd_mobilenetv1_model-weights_manifest.json",
//        "ssd_mobilenetv1_model-shard1",
//        "ssd_mobilenetv1_model-shard2",
//        "face_landmark_68_model-shard1",
//        "face_landmark_68_model-weights_manifest.json")

    var sourceStrArr = arrayOf(
        "ssd_mobilenetv1_model-weights_manifest.json",
        "face_landmark_68_model-weights_manifest.json")

    var sourceStrArr2 = arrayOf(
         "ssd_mobilenetv1_model-shard1",
        "ssd_mobilenetv1_model-shard2",
        "face_landmark_68_model-shard1",)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(this@QimuActivity, arrayOf(Manifest.permission.CAMERA),1010)
        setContentView(R.layout.activity_qimu)
        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.defaultTextEncodingName = "UTF-8"
        webView.settings.allowContentAccess = true // 是否可访问Content Provider的资源，默认值 true
        webView.settings.allowFileAccess = true
        webView.settings.allowContentAccess = true
        webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
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
                        val fileUrl = request.url.toString()
                        for(str in sourceStrArr) {
                            if (fileUrl.indexOf(str,-1) > 0) {
                                var sourceFile: InputStream? = null
                                try {
                                    sourceFile = applicationContext.assets.open("web/"+str)
//                                    var extension: String = MimeTypeMap.getFileExtensionFromUrl(str)
//                                    var mimeType: String? = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
                                    Log.d("QimuActivity", sourceFile.toString())
                                } catch (e: IOException) {
                                    Log.e("QimuActivity", e.toString())
                                    e.printStackTrace()
                                }
//                                var webResourceResponse: WebResourceResponse = WebResourceResponse("application/json", "utf-8", sourceFile)
//                                return webResourceResponse

                            }
                        }
//                        for(str2 in sourceStrArr2) {
//                            if (fileUrl.indexOf(str2,-1) > 0) {
//                                var sourceFile: InputStream? = null
//                                try {
//                                    sourceFile = applicationContext.assets.open(str2)
////                                    var extension: String = MimeTypeMap.getFileExtensionFromUrl(str)
////                                    var mimeType: String? = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
//                                    Log.d("QimuActivity", sourceFile.toString())
//                                } catch (e: IOException) {
//                                    Log.e("QimuActivity", e.toString())
//                                    e.printStackTrace()
//                                }
//                                return WebResourceResponse("application/octet-stream", "utf-8", sourceFile)
//                            }
//                        }
                        Log.d("QimuActivity", request.url.toString())
                    }
                }
                return super.shouldInterceptRequest(view, request)
            }
        }



        webView.loadUrl("https://liveness.zanatest.com/#/kyc-about")
    }


}



