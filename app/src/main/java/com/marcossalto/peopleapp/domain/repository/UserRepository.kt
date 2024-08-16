package com.marcossalto.peopleapp.domain.repository

import com.marcossalto.peopleapp.domain.model.User
import kotlinx.coroutines.flow.Flow

typealias Users = List<User>
interface UserRepository {
    suspend fun addUserToRoom(user: User)
    suspend fun updateUserFromRoom(user: User)
    suspend fun deleteUserFromRoom(user: User)
    suspend fun getUserByIdFromRoom(id: Int): User?
    fun getUsersFromRoom(): Flow<Users>
}
