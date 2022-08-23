package br.google.developer.adogtme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.R
import br.google.developer.adogtme.fragments.MyAdoptionRequestsFragment
import br.google.developer.adogtme.fragments.PetCollectionFragment
import br.google.developer.adogtme.models.AdoptionRequest
import br.google.developer.adogtme.models.Pet

class AdoptionRequestAdapter(
    private val context: Context?,
    private val data: List<AdoptionRequest>,
    private val fragment: MyAdoptionRequestsFragment?
): RecyclerView.Adapter<AdoptionRequestAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View, private val lifecycleOwner: LifecycleOwner): RecyclerView.ViewHolder(view) {
        val icTrash: View = view.findViewById(R.id.ic_trash)
        val itemCard: View = view.findViewById(R.id.item_card)
        val itemCardImage: ImageView = view.findViewById(R.id.item_card_image)
        val itemCardTitle: TextView = view.findViewById(R.id.item_card_title)
        val itemCardDescription: TextView = view.findViewById(R.id.item_card_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val lifeCycleOwner = parent.context as LifecycleOwner
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.adoption_card_item, parent, false)
        return ItemViewHolder(adapterLayout, lifeCycleOwner )


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if(data == null)
            return;
        val item = data[position]
        holder.itemCardImage.setImageResource(item.pet.avatar)
        holder.itemCardTitle.text =  item.pet.firstname
        holder.itemCardDescription.text =  item.pet.city

        val params = holder.itemView.layoutParams


        if (!item.active) {
            params.height = 0
            params.width = 0
            holder.itemView.layoutParams = params
        }

        holder.icTrash.setOnClickListener {
            fragment?.handleRemovePetOnMyAdoptions(item)
        }

        holder.itemCard.setOnClickListener {
            fragment?.handleGoToPetDetails(item.pet)
        }


    }

    override fun getItemCount() = data.size
}


