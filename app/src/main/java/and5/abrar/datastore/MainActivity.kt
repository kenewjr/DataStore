package and5.abrar.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var  usermanager : UserManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usermanager = UserManager(this)
        btnSave.setOnClickListener {
            val nama = inName.text.toString()
            val umur = inAge.text.toString().toInt()
            GlobalScope.launch {
                usermanager.saveData(nama, umur)
            }
        }
        usermanager.userNama.asLiveData().observe(this) {
            resultnama.text = it.toString()
        }

        usermanager.userUmur.asLiveData().observe(this) {
            resultage.text = it.toString()
        }
        btnClear.setOnClickListener {
            GlobalScope.launch {
                usermanager.hapusData()
            }
        }
    }
}