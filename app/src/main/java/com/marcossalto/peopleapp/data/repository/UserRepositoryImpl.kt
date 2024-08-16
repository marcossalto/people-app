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
    override suspend fun addUserToRoom(user: User) {
        userDao.addUser(user)
    }

    override suspend fun updateUserFromRoom(user: User) {
        userDao.updateUser(user)
    }

    override suspend fun deleteUserFromRoom(user: User) {
        userDao.deleteUser(user)
    }

    override suspend fun getUserByIdFromRoom(id: Int): User? {
        return userDao.getUserById(id)
    }

    override fun getUsersFromRoom(): Flow<Users> {
        return userDao.getUsers()
    }
}
