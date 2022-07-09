package kg.geektech.mathematicianskg.presentation.web_view

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.mathematicianskg.R
import kg.geektech.mathematicianskg.databinding.ActivityWebViewBinding

@AndroidEntryPoint
class WebView : AppCompatActivity(R.layout.activity_web_view) {

    private val binding: ActivityWebViewBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val intent = intent
        val url = intent.getStringExtra("url")
        binding.webView.webViewClient = WebViewClient()
        url?.let { binding.webView.loadUrl(it) }
    }
}
