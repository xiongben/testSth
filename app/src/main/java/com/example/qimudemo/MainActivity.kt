package com.example.qimudemo

import android.Manifest
import android.app.AlertDialog
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.*
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    val instance by lazy { this }
    lateinit var webkitPermissionRequest : PermissionRequest

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val btn:Button = findViewById(R.id.btn)
//        btn.setOnClickListener {
//            println(QimuObj.aa)
////            QimuObj.hello()
//            println("===============")
//            val intent = Intent(this, QimuActivity::class.java)
//            startActivity(intent)
//        }

        val webView: WebView = findViewById(com.example.qimulibrary.R.id.webView)
        webView.settings.javaScriptEnabled = true

        webView.settings.domStorageEnabled = true;
        webView.settings.defaultTextEncodingName = "UTF-8";
        webView.settings.allowContentAccess = true; // 是否可访问Content Provider的资源，默认值 true
        webView.settings.allowFileAccess = true;
        webView.settings.allowContentAccess = true
        webView.settings.mediaPlaybackRequiresUserGesture = false



//        webView.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                // WebView加载该Url
//                return false
//            }
//        }



        webView.webChromeClient = object : WebChromeClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onPermissionRequest(request: PermissionRequest?) {

                Log.i(TAG, "onPermissionRequest")

                // grants permission for app. video not showing
                if (ContextCompat.checkSelfPermission(instance, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    Log.i(TAG, "Request Permission")
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(arrayOf(Manifest.permission.CAMERA), 1010)
                    }
                } else {
                    Log.i(TAG, "Permission already granted")
                }


                super.onPermissionRequest(request)

//                val requestedResources = request?.resources
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    request?.grant(requestedResources)
//                }
//                if (requestedResources != null) {
//                    for (r in requestedResources) {
//                        Log.d("My Request", "onPermissionRequest: " + r)
//                        request.grant(arrayOf(r))
//                        if (r == PermissionRequest.RESOURCE_VIDEO_CAPTURE) {
////                            Log.d("My Request", "onPermissionRequest: " + requestedResources)
////                            request.grant(arrayOf(PermissionRequest.RESOURCE_VIDEO_CAPTURE))
////                            break
//                            val alertDialogBuilder = AlertDialog.Builder(instance)
//                                .setTitle("Allow Permission to camera")
//                                .setPositiveButton("Allow") { dialog, which ->
//                                    dialog.dismiss()
////                                    requestPermissions(instance, arrayOf(Manifest.permission.CAMERA), 1010)
////                                    webkitPermissionRequest.grant(arrayOf(PermissionRequest.RESOURCE_VIDEO_CAPTURE))
//                                    Log.d(TAG, "Granted")
//                                }
//                                .setNegativeButton("Deny") { dialog, which ->
//                                    dialog.dismiss()
////                                    webkitPermissionRequest.deny()
//                                    Log.d(TAG, "Denied")
//                                }
//                            val alertDialog = alertDialogBuilder.create()
//                            alertDialog.show()
//                            break
//                        }
//                    }
//                }
            }

//            override fun onShowFileChooser(
//                webView: WebView?,
//                filePathCallback: ValueCallback<Array<Uri>>?,
//                fileChooserParams: FileChooserParams?
//            ): Boolean {
//                println(fileChooserParams)
//                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
//            }
        }


//        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://liveness.zanatest.com/#/test-page")

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        for (r in grantResults) {
//            Log.d("MainActivity", "demo Request:" + r)
//        }

        when (requestCode) {
            1010 -> {
                Log.d("MainActivity", "onRequestPermissionsResult: Camera Request")
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Log.d("MainActivity", "Camera Request: Permission granted")
                    // permission was granted, yay!
                } else {
                    // permission denied, boo!
                    Log.d("MainActivity", "Camera Request: Permission denied")
                }
                return
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}