package com.junior.sqlitecomroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Tabela usuario

//Por meio dela que mostramos que essa classe é uma tabela
@Entity(tableName = "user_table")
class Usuario (

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nome: String,
    val sobrenome: String,
    val idade: Int
        ) {
}