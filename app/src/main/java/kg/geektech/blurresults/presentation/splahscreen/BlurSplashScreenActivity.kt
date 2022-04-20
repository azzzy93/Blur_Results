package kg.geektech.blurresults.presentation.splahscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.blurresults.presentation.activity.MainActivity

@SuppressLint("CustomSplashScreen")
class BlurSplashScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}