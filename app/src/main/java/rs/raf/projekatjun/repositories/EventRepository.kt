package rs.raf.projekatjun.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekatjun.models.EventEntity
import rs.raf.projekatjun.models.EventResponse

interface EventRepository {

    fun insert(eventEntity: EventEntity): Completable
    fun fetchAll(par: String): Observable<EventResponse>
    fun getAllEvents(): Observable<List<EventEntity>>
    fun deleteEvent(eventEntity: EventEntity): Completable


}