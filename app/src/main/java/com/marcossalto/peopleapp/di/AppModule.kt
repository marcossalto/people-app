package com.marcossalto.peopleapp.di

import android.content.Context
import androidx.room.Room
import com.marcossalto.peopleapp.core.Constants.Companion.DATABASE_NAME
import com.marcossalto.peopleapp.data.repository.UserRepositoryImpl
import com.marcossalto.peopleapp.data.source.local.UserDB
import com.marcossalto.peopleapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDB(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        UserDB::class.java,
        DATABASE_NAME
    )
        .build()

    @Singleton
    @Provides
    fun provideUserRepository(
        userDB: UserDB
    ): UserRepository = UserRepositoryImpl(userDB.userDao())

    @Provides
    @Singleton
    fun provideUserDao(userDB: UserDB) = userDB.userDao()
}
