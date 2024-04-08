package rs.raf.projekatjun.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekatjun.models.EventEntity

class TestViewModel : ViewModel() {

    private val events : MutableLiveData<List<EventEntity>> = MutableLiveData()
    private val eventList : MutableList<EventEntity> = mutableListOf()

    init{
        val event1 = EventEntity(0,"ime","desc", "25:06:2021", "04:20", "something", "Hard")
        eventList.add(event1)
        val event2 = EventEntity(0,"ime2","desc2", "25:06:2021", "04:20", "something2", "Hard")
        eventList.add(event2)
        val event3 = EventEntity(0,"ime3","desc3", "25:06:2021", "04:20", "something3", "Hard")
        eventList.add(event3)
        val event4 = EventEntity(0,"ime4","desc4", "25:06:2021", "04:20", "something4", "Hard")
        eventList.add(event4)

        val listToSubmit = mutableListOf<EventEntity>()
        listToSubmit.addAll(eventList)
        events.value = listToSubmit

    }

    fun getEvents() : LiveData<List<EventEntity>> {
        return events
    }


}