package com.marcossalto.peopleapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marcossalto.peopleapp.core.Constants.Companion.USER_ID
import com.marcossalto.peopleapp.core.Constants.Companion.USER_TABLE
import com.marcossalto.peopleapp.domain.model.User
import com.marcossalto.peopleapp.domain.repository.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM $USER_TABLE WHERE $USER_ID = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM $USER_TABLE ORDER BY $USER_ID ASC")
    fun getUsers(): Flow<Users>

    @Query("DELETE FROM $USER_TABLE WHERE $USER_ID = :id")
    suspend fun deleteUserById(id: String)

    @Query("DELETE FROM $USER_TABLE")
    suspend fun deleteAllUsers()
}
