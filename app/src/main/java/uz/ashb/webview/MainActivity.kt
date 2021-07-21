package uz.ashb.webview

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var url = "https://www.google.co.uz/"
    lateinit var processDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.loadUrl(url)
        processDialog = ProgressDialog(this)
        processDialog.setMessage("Loading... ")

        web_view.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
//                progress_bar.visibility = View.VISIBLE
                processDialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                processDialog.hide()

//                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.my_anim)
//                progress_bar.startAnimation(animation)
//                animation.setAnimationListener(object : Animation.AnimationListener{
//                    override fun onAnimationRepeat(animation: Animation?) {
//
//                    }
//
//                    override fun onAnimationEnd(animation: Animation?) {
//                        progress_bar.visibility = View.GONE
//                    }
//
//                    override fun onAnimationStart(animation: Animation?) {
//
//                    }
//                })
            }
        }
    }
}
