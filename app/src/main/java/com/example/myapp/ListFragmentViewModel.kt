import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.myapp.room.DbConnection

import kotlinx.coroutines.launch

class ListFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val userEntityDao =
        Room.databaseBuilder(application, DbConnection::class.java, "database")
            .build()
            .entityDao()

    val list = userEntityDao.getAll()


    fun insert(userData: com.example.myapp.room.UserData){
        viewModelScope.launch {
            userEntityDao.insert(userData)
        }
    }

}