package kg.geektech.blurresults.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geektech.blurresults.domain.entity.PlayerResult
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.game.usecase.EditPlayerUseCase
import kg.geektech.blurresults.domain.game.usecase.GetPlayersUseCase
import kg.geektech.blurresults.domain.results.repository.AddResultRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase,
    private val editPlayerUseCase: EditPlayerUseCase,
    private val addResultRepository: AddResultRepository
) :
    ViewModel() {

    private val _playersList = MutableStateFlow<List<PlayerResult>>(mutableListOf())
    val playersList = _playersList.asStateFlow()

    init {
        getPlayers()
    }

    private fun getPlayers() {
        viewModelScope.launch {
            getPlayersUseCase.invoke()
                .collect {
                    _playersList.value = it
                }
        }
    }

    fun editPlayer(player: PlayerResult) {
        viewModelScope.launch {
            editPlayerUseCase.invoke(player)
        }
    }

    fun insertResult(result: ResultGameEntity) {
        viewModelScope.launch {
            addResultRepository.addResult(result)
        }
    }

}