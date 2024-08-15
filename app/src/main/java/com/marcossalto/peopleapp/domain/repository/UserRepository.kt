package com.marcossalto.peopleapp.domain.repository

import com.marcossalto.peopleapp.domain.model.User
import kotlinx.coroutines.flow.Flow

typealias Users = List<User>
interface UserRepository {
    fun addUserToRoom(user: User)
    fun updateUserFromRoom(user: User)
    fun deleteUserFromRoom(user: User)
    fun getUserByIdFromRoom(id: Int): User?
    fun getUsersFromRoom(): Flow<Users>
}
