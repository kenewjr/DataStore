package and5.abrar.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserData(context: Context) {
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_pref")
    companion object{
        val NAMA = preferencesKey<String>("usernama")
        val PASS = preferencesKey<String>("passpass")
    }

    suspend fun saveData(nama : String, pass:String){
        dataStore.edit {
            it[NAMA]= nama
            it[PASS]= pass
        }
    }
    val userNama : Flow<String> = dataStore.data.map {
        it[NAMA] ?:""
    }
    val userPass : Flow<String> = dataStore.data.map {
        it[PASS] ?:""
    }
    suspend fun hapusData(){
        dataStore.edit {
            it.clear()
        }
    }
}