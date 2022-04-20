package kg.geektech.blurresults.presentation.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.usecase.GetResultsUseCase
import kg.geektech.blurresults.domain.results.usecase.RemoveResultUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val getResultsUseCase: GetResultsUseCase,
    private val removeResultUseCase: RemoveResultUseCase
    ) : ViewModel() {

    private val _resultsList = MutableStateFlow<List<ResultGameEntity>>(mutableListOf())
    val resultList = _resultsList.asStateFlow()

    init {
        getResults()
    }

    private fun getResults() {
        viewModelScope.launch {
            getResultsUseCase.invoke()
                .collect {
                    _resultsList.value = it
                }
        }
    }

    fun removeResult(result: ResultGameEntity) {
        viewModelScope.launch {
            removeResultUseCase.invoke(result)
        }
    }

}