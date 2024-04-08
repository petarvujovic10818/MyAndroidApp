package rs.raf.projekatjun.datasources

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.projekatjun.models.EventEntity

@Database(
    entities = [EventEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class EventDataBase : RoomDatabase() {
    abstract fun getEventDao(): EventDao
}