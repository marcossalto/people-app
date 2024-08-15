package com.marcossalto.peopleapp.data.repository

import com.marcossalto.peopleapp.data.source.local.dao.UserDao
import com.marcossalto.peopleapp.domain.model.User
import com.marcossalto.peopleapp.domain.repository.UserRepository
import com.marcossalto.peopleapp.domain.repository.Users
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): UserRepository {
    override fun addUserToRoom(user: User) {
        userDao.addUser(user)
    }

    override fun updateUserFromRoom(user: User) {
        userDao.updateUser(user)
    }

    override fun deleteUserFromRoom(user: User) {
        userDao.deleteUser(user)
    }

    override fun getUserByIdFromRoom(id: Int): User? {
        return userDao.getUserById(id)
    }

    override fun getUsersFromRoom(): Flow<Users> {
        return userDao.getUsers()
    }
}
