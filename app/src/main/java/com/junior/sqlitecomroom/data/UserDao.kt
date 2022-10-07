package com.junior.sqlitecomroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//coloca tudo que é requisição

//Para saber que vai receber requisições
@Dao
interface UserDao {

    //Insert mostra que vamos usar essa função para inserir dados
    //caso tenha algum usuario duplicado, ele ignora
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(usuario: Usuario)

    //Dentro do query usar comandos sql, nesse caso para mostrar todos os usuarios pelo ID
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun selectUser(): LiveData<List<Usuario>>

}