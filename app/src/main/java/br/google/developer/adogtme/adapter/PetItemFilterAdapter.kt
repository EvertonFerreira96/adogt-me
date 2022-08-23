package br.google.developer.adogtme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.R
import br.google.developer.adogtme.fragments.PetCollectionFragment
import br.google.developer.adogtme.models.PetFilter

class PetItemFilterAdapter(
    private val context: Context?,
    private val data: List<PetFilter>,
    private val fragment: PetCollectionFragment?
): RecyclerView.Adapter<PetItemFilterAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val itemFilterImage: ImageView = view.findViewById(R.id.pet_filter)
        val itemFilterContainer: View = view.findViewById(R.id.pet_filter_wrapper)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_filter_item, parent, false)
        return ItemViewHolder(adapterLayout)


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]

        holder.itemFilterImage.setImageResource(item.avatar)
        holder.itemFilterImage.setOnClickListener {
            fragment?.handleFilterPet(item)
        }

        if(item.active === true)
            holder.itemFilterContainer.setBackgroundResource(R.drawable.image_border)
        else
            holder.itemFilterContainer.setBackgroundResource(0)

    }

    override fun getItemCount() = data.size
}

