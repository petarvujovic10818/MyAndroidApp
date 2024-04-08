package rs.raf.projekatjun.recycler

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import rs.raf.projekatjun.databinding.ItemEventBinding
import rs.raf.projekatjun.models.EventEntity

class EventViewHolder(private val itemBinding: ItemEventBinding, onItemClicked: (Int) -> Unit): RecyclerView.ViewHolder(itemBinding.root) {

    init {
        //itemView.setOnClickListener{
            //onItemClicked.invoke(adapterPosition)
        //}

        itemBinding.recyclerImageView.setOnClickListener{
            onItemClicked.invoke(adapterPosition)
        }


    }

    fun bind(eventEntity: EventEntity){
        itemBinding.recyclerIme.text = eventEntity.ime
        itemBinding.recyclerOpis.text = eventEntity.opis
        itemBinding.recyclerDatum.text = eventEntity.datum
        itemBinding.recyclerVreme.text = eventEntity.vreme
        itemBinding.recyclerUrl.text = eventEntity.url
        if(eventEntity.difficulty=="High"){
            itemView.setBackgroundColor(Color.RED)
        } else if(eventEntity.difficulty=="Medium"){
            itemView.setBackgroundColor(Color.GREEN)
        }else if(eventEntity.difficulty=="Low"){
            itemView.setBackgroundColor(Color.WHITE)
        }
    }

}