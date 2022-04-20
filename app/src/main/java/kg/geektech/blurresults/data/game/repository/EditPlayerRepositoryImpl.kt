package kg.geektech.blurresults.data.game.repository

import kg.geektech.blurresults.data.game.local.GameApi
import kg.geektech.blurresults.domain.entity.PlayerResult
import kg.geektech.blurresults.domain.game.repository.EditPlayerRepository
import javax.inject.Inject

class EditPlayerRepositoryImpl @Inject constructor(private val gameApi: GameApi) :
    EditPlayerRepository {

    override suspend fun editPlayer(player: PlayerResult) {
        gameApi.editPlayers(player)
    }

}