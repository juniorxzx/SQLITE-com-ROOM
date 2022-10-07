package com.junior.sqlitecomroom.data

class UserRepository(private val userDao: UserDao) {

    val selectUser = userDao.selectUser()

    fun addUser(usuario: Usuario){
        userDao.addUser(usuario)
    }
}