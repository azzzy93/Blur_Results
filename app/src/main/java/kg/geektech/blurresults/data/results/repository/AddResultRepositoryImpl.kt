package kg.geektech.blurresults.data.results.repository

import kg.geektech.blurresults.data.results.local.ResultsDao
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.AddResultRepository
import javax.inject.Inject

class AddResultRepositoryImpl @Inject constructor(private val resultsDao: ResultsDao) :
    AddResultRepository {

    override suspend fun addResult(result: ResultGameEntity) {
        resultsDao.insertResult(result)
    }

}