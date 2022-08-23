package br.google.developer.adogtme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.R
import br.google.developer.adogtme.fragments.PetDetailFragment
import br.google.developer.adogtme.models.PetAttribute

class PetAttributeCardAdapter(
    private val context: Context?,
    private val data: List<PetAttribute>,
    private val fragment: PetDetailFragment?
): RecyclerView.Adapter<PetAttributeCardAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val itemCardProgress: ProgressBar = view.findViewById(R.id.attr_amount)
        val itemCardKey: TextView = view.findViewById(R.id.attr_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_atributte_item, parent, false)
        return ItemViewHolder(adapterLayout)


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.itemCardKey.text =  item.key.toString()
        holder.itemCardProgress.progress = item.value * 10

    }

    override fun getItemCount() = data.size
}

