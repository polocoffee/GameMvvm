package com.banklannister.gamemvvm.di

import android.content.Context
import androidx.room.Room
import com.banklannister.gamemvvm.data.local.GameDatabase
import com.banklannister.gamemvvm.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, GameDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideGameDao(gameDatabase: GameDatabase) = gameDatabase.getGameDao()

}