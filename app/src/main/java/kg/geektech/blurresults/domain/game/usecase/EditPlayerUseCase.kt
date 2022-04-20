package kg.geektech.blurresults.domain.game.usecase

import kg.geektech.blurresults.domain.entity.PlayerResult
import kg.geektech.blurresults.domain.game.repository.EditPlayerRepository
import javax.inject.Inject

class EditPlayerUseCase @Inject constructor(private val repository: EditPlayerRepository) {

    suspend fun invoke(player: PlayerResult) {
        repository.editPlayer(player)
    }

}