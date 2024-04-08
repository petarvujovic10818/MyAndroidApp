package rs.raf.projekatjun.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val ime:String,
    val opis:String,
    val datum:String,
    val vreme:String,
    val url:String,
    val difficulty: String
)
