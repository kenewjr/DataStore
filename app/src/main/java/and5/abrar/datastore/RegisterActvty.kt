package and5.abrar.datastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_actvty.*
import kotlinx.android.synthetic.main.activity_register_actvty.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActvty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var  usermanager : UserData
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_actvty)
        usermanager = UserData(this)
        btnregis.setOnClickListener {
          val nama = et_nama.text.toString()
          val pass = et_pass.text.toString()
            GlobalScope.launch {
                usermanager.saveData(nama, pass)
            }
            startActivity(Intent(this, LoginActvty::class.java))

        }
    }
}