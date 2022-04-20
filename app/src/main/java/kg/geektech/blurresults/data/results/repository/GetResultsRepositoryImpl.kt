package kg.geektech.blurresults.data.results.repository

import kg.geektech.blurresults.data.results.local.ResultsDao
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.GetResultsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResultsRepositoryImpl @Inject constructor(private val resultsDao: ResultsDao) :
    GetResultsRepository {

    override suspend fun getResults(): Flow<List<ResultGameEntity>> {
        return resultsDao.getAllResults()
    }
}