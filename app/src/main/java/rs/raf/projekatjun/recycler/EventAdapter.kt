package rs.raf.projekatjun.recycler


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekatjun.databinding.ItemEventBinding
import rs.raf.projekatjun.models.EventEntity

class EventAdapter(eventDiffer: EventDiffer, private val onEventClicked: (EventEntity) -> Unit): ListAdapter<EventEntity, EventViewHolder>(eventDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemBinding =ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(itemBinding){
            val event = getItem(it)
            onEventClicked.invoke(event)
        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}