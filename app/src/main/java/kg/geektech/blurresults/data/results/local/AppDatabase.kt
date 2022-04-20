package kg.geektech.blurresults.data.results.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.geektech.blurresults.domain.entity.ResultGameEntity

@Database(entities = [ResultGameEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun resultsDao(): ResultsDao

}