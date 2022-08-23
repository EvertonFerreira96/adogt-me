package br.google.developer.adogtme.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.R
import br.google.developer.adogtme.fragments.PetCollectionFragment
import br.google.developer.adogtme.models.Pet

const val TAG = "PetCardAdapter";

class PetCardAdapter(
    private val context: Context?,
    private val data: MutableList<Pet>,
    private val fragment: PetCollectionFragment
): RecyclerView.Adapter<PetCardAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View, private val lifecycleOwner: LifecycleOwner): RecyclerView.ViewHolder(view) {
        val itemCard: View = view.findViewById(R.id.item_card)
        val itemCardImage: ImageView = view.findViewById(R.id.item_card_image)
        val itemCardTitle: TextView = view.findViewById(R.id.item_card_title)
        val itemCardDescription: TextView = view.findViewById(R.id.item_card_description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val lifeCycleOwner = parent.context as LifecycleOwner
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_card_item, parent, false)
        return ItemViewHolder(adapterLayout, lifeCycleOwner )


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data!![position]

        val params = holder.itemView.layoutParams

        if (item.active.value == false) {
            params.height = 0
            params.width = 0
            holder.itemView.layoutParams = params
        }

        holder.itemCardImage.setImageResource(item.avatar)
        holder.itemCardTitle.text =  item.firstname
        holder.itemCardDescription.text =  item.city

        holder.itemCard.setOnClickListener {
            fragment?.handleGoToPetDetails(item)
        }
    }

    override fun getItemCount() = data.size
}

