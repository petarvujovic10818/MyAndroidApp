package rs.raf.projekatjun.datasources

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekatjun.models.EventEntity

@Dao
abstract class EventDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(eventEntity: EventEntity): Completable //insertovanje entitija u lokalnu bazu

    //@Insert( onConflict = OnConflictStrategy.REPLACE )
    //abstract fun insertAll(entities: List<EventEntity>): Completable

    @Query("SELECT * FROM events")
    abstract fun getAllEvents(): Observable<List<EventEntity>> //observable list event entitija

    @Delete
    abstract fun deleteEvent(eventEntity: EventEntity): Completable

}