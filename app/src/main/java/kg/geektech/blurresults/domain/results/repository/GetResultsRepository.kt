package kg.geektech.blurresults.domain.results.repository

import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kotlinx.coroutines.flow.Flow

interface GetResultsRepository {

    suspend fun getResults(): Flow<List<ResultGameEntity>>

}