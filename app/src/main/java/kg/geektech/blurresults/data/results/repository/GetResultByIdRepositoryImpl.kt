package kg.geektech.blurresults.data.results.repository

import kg.geektech.blurresults.data.results.local.ResultsDao
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.GetResultByIdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResultByIdRepositoryImpl @Inject constructor(private val resultsDao: ResultsDao) :
    GetResultByIdRepository {

    override suspend fun getResultById(id: Int): Flow<ResultGameEntity> {
        return resultsDao.getResultById(id)
    }

}