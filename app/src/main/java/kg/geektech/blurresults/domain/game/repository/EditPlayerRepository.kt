package kg.geektech.blurresults.domain.game.repository

import kg.geektech.blurresults.domain.entity.PlayerResult

interface EditPlayerRepository {

    suspend fun editPlayer(player: PlayerResult)

}