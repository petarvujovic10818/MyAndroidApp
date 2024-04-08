package rs.raf.projekatjun.recycler

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekatjun.models.EventEntity

class EventDiffer: DiffUtil.ItemCallback<EventEntity>() {

    override fun areItemsTheSame(oldItem: EventEntity, newItem: EventEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EventEntity, newItem: EventEntity): Boolean {
        return oldItem.ime == newItem.ime
    }
}