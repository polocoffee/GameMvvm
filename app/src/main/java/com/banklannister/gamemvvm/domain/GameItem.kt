package com.banklannister.gamemvvm.domain

import com.banklannister.gamemvvm.data.local.GameEntity
import com.banklannister.gamemvvm.data.remote.GameModel

data class GameItem(

    val id: Int,
    val title: String,
    val thumbnail: String

)

fun GameModel.toDomain() = GameItem(id = id, title = title, thumbnail = thumbnail)
fun GameEntity.toDomain() = GameItem(id = id, title = title, thumbnail = thumbnail)