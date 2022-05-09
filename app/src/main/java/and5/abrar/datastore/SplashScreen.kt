package and5.abrar.datastore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var  usermanager : UserData
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        usermanager = UserData(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if(usermanager.userNama != null){
                startActivity(Intent(this, HomeActvty::class.java))
            }else{
                startActivity(Intent(this, LoginActvty::class.java))
            }
        },3000)
    }
}