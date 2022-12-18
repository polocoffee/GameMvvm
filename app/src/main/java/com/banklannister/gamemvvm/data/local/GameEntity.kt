package com.banklannister.gamemvvm.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.banklannister.gamemvvm.domain.GameItem

@Entity(tableName = "game_table")
data class GameEntity(

    @PrimaryKey
    val id: Int,
    val title: String,
    val thumbnail: String

)

fun GameItem.toDatabase() = GameEntity(id = id, title = title, thumbnail = thumbnail)