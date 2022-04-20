package kg.geektech.blurresults.data.results.local

import androidx.room.*
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultsDao {

    @Query("SELECT * FROM resultsList ORDER BY id DESC")
    fun getAllResults(): Flow<List<ResultGameEntity>>

    @Query("SELECT * FROM resultsList WHERE id = :resultId")
    fun getResultById(resultId: Int): Flow<ResultGameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: ResultGameEntity)

    @Delete
    suspend fun deleteResult(result: ResultGameEntity)

}