package rs.raf.projekatjun.contract

import androidx.lifecycle.LiveData
import rs.raf.projekatjun.models.Event
import rs.raf.projekatjun.models.EventEntity
import rs.raf.projekatjun.models.EventResponse

interface MainContract {

    interface ViewModel{

        val events: LiveData<List<EventEntity>> //za getovanej svih eventova getAllEvents
        val time: LiveData<EventResponse>

        fun addEvent(eventEntity: EventEntity)
        fun getAllEvents()
        fun deleteEvent(eventEntity: EventEntity)
        fun fetchAll(par: String)
    }

}