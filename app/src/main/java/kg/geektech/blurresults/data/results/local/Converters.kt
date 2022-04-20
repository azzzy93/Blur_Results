package kg.geektech.blurresults.data.results.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.geektech.blurresults.domain.entity.PlayerResult

object Converters {

    @TypeConverter
    fun listToJson(value: List<PlayerResult>): String {
        val type = object : TypeToken<List<PlayerResult>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun jsonToList(value: String): List<PlayerResult> {
        val type = object : TypeToken<List<PlayerResult>>() {}.type
        return Gson().fromJson(value, type)
    }

}