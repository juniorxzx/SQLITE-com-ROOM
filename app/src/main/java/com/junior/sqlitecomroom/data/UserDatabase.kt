package com.junior.sqlitecomroom.data

import android.content.Context
import androidx.room.*

// mostra que é um banco de dados
//entites aqui mostra que teremos entidades onde passa um array de Usuario
//version para informar a versão do seu banco de dados
//exportSChema deixamos false porque não queremos exportar os scripts do banco por fora

@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    //retornar a interface e ter acesso as requisições
    abstract fun userDao(): UserDao

    companion object{
        //ficar visivel para todas as threds do app a partir do momento que for instaciada
        @Volatile
        private var INSTANCE: UserDatabase? = null

        //verificar se existe ou não, uma instancia e se existir retornar ela
        fun getDataBase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            //colocar para ganhar prioridade na thred onde está sendo executado
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()

                INSTANCE = instance
                return  instance
            }
        }
    }
}