package com.marcossalto.peopleapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marcossalto.peopleapp.data.source.local.dao.UserDao
import com.marcossalto.peopleapp.domain.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDB: RoomDatabase() {
    abstract val dao: UserDao
}
