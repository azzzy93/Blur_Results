package kg.geektech.blurresults.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resultsList")
data class ResultGameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val date: String? = null,
    val gameDuration: String? = null,
    val numberOfRounds: Int? = null,
    val winnerPlayerName: String? = null,
    val playersResults: List<PlayerResult>? = null
)

data class PlayerResult(
    val id: Int? = null,
    val name: String? = null,
    val winCount: Int = 0,
    val lossCount: Int = 0,
    val total: Int = 0
)
