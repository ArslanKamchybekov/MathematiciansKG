package kg.geektech.mathematicianskg.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.mathematicianskg.presentation.main.MainActivity
import kg.geektech.mathematicianskg.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        CoroutineScope(Dispatchers.IO).launch {
            delay(2500L)
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        }
    }
}