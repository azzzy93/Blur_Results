package kg.geektech.blurresults.presentation.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.usecase.GetResultByIdUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val getResultByIdUseCase: GetResultByIdUseCase
) : ViewModel() {

    private val _result = MutableStateFlow(ResultGameEntity())
    val result = _result.asStateFlow()

    fun getResult(id: Int) {
        viewModelScope.launch {
            getResultByIdUseCase.invoke(id)
                .collect {
                    _result.value = it
                }
        }
    }

}