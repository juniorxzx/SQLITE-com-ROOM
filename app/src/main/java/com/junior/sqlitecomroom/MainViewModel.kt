package com.junior.sqlitecomroom

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junior.sqlitecomroom.data.UserDatabase
import com.junior.sqlitecomroom.data.UserRepository
import com.junior.sqlitecomroom.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        //pegamos um objeto que tem a implementação de UserDao
        val userDao = UserDatabase.getDataBase(application).userDao()
        repository = UserRepository(userDao)

        selectUsers = repository.selectUser
    }

    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(usuario)
        }
    }
}