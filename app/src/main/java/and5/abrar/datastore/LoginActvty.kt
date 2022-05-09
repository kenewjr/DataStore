package and5.abrar.datastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_login_actvty.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register_actvty.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActvty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var usermanager : UserData
        lateinit var namauser : String
        lateinit var passuser : String
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_actvty)
        usermanager = UserData(this)

        usermanager.userNama.asLiveData().observe(this) {
            namauser = it.toString()
        }
        usermanager.userPass.asLiveData().observe(this) {
            passuser = it.toString()
        }
        btnLogin.setOnClickListener {
            val inNama = nama.text.toString()
            val inPass = pass.text.toString()
                if (inNama == namauser && passuser == inPass) {
                    startActivity(Intent(this, HomeActvty::class.java))
                    Toast.makeText(this, "ini benar", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "ini salah", Toast.LENGTH_SHORT).show()
                }
        }
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActvty::class.java))
        }

    }
}