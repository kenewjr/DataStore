package and5.abrar.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserManager(context: Context) {
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    companion object{
        val NAMA = preferencesKey<String>("usernama")
        val UMUR = preferencesKey<Int>("userumur")
    }

    suspend fun saveData(nama : String,umur:Int){
        dataStore.edit {
            it[NAMA]= nama
            it[UMUR]=umur
        }
    }
    val userNama : Flow<String> = dataStore.data.map {
        it[NAMA] ?:""
    }
    val userUmur : Flow<Int> = dataStore.data.map {
        it[UMUR] ?:0
    }
    suspend fun hapusData(){
        dataStore.edit {
            it.clear()
        }
    }
}