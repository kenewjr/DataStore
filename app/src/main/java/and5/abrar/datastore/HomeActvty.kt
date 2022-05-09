package and5.abrar.datastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_home_actvty.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActvty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var  usermanager : UserData
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_actvty)
        usermanager = UserData(this)
        usermanager.userNama.asLiveData().observe(this) {
            tv_muncul.text = it.toString()
        }
        btnLogout.setOnClickListener {
            GlobalScope.launch {
                usermanager.hapusData()
            }
            startActivity(Intent(this, LoginActvty::class.java))
        }
    }
}