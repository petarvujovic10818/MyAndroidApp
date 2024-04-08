package rs.raf.projekatjun.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekatjun.datasources.EventDao
import rs.raf.projekatjun.datasources.EventService
import rs.raf.projekatjun.models.Event
import rs.raf.projekatjun.models.EventEntity
import rs.raf.projekatjun.models.EventResponse

class EventRepositoryImpl(private val localDataSource: EventDao, private val remoteDataSource: EventService): EventRepository {

    override fun insert(eventEntity: EventEntity): Completable {
        return localDataSource.insert(eventEntity)
    }

    override fun fetchAll(par: String): Observable<EventResponse> {
        return remoteDataSource
            .getAll(par)
    }

    override fun getAllEvents(): Observable<List<EventEntity>> {
        return localDataSource.getAllEvents()
    }

    override fun deleteEvent(eventEntity: EventEntity): Completable {
        return localDataSource.deleteEvent(eventEntity)
    }

}