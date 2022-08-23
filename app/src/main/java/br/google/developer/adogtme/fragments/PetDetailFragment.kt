package br.google.developer.adogtme.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.MainActivity
import br.google.developer.adogtme.R
import br.google.developer.adogtme.adapter.PetAttributeCardAdapter
import br.google.developer.adogtme.databinding.FragmentPetDetailBinding
import br.google.developer.adogtme.models.AdoptionRequest
import br.google.developer.adogtme.views.AccountViewModel
import br.google.developer.adogtme.views.AdoptionRequestViewModel
import br.google.developer.adogtme.views.PetViewModel

class PetDetailFragment : Fragment() {

    private var binding: FragmentPetDetailBinding? = null

    private val accountSharedViewModelInternal: AccountViewModel by activityViewModels()

    private val petSharedViewModelInternal: PetViewModel by activityViewModels()

    private val adoptionRequestSharedViewModelInternal: AdoptionRequestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding =  FragmentPetDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.errorMessage?.visibility = TextView.INVISIBLE

        petSharedViewModelInternal.focusPet.value?.let {
            binding?.thumbnail?.setImageResource(it.avatar)
            binding?.title?.text = it.firstname
            binding?.description?.text = it.description
            binding?.ownerAvatar?.setImageResource(it.ownerPet.avatar)
            binding?.ownerName?.text = it.ownerPet.name
            binding?.errorMessage?.visibility = TextView.VISIBLE
        }

        val recyclerPetCard = view.findViewById<RecyclerView>(R.id.recycler_pet_attribute_card)
        recyclerPetCard.adapter = petSharedViewModelInternal.focusPet.value?.attrs?.let { PetAttributeCardAdapter(context, it, this@PetDetailFragment) }
        recyclerPetCard.setHasFixedSize(true)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            accountSharedViewModel = accountSharedViewModelInternal
            petSharedViewModel = petSharedViewModelInternal
            adoptionRequestSharedViewModel = adoptionRequestSharedViewModelInternal
            fragment = this@PetDetailFragment
        }
    }

    fun goBack(){
        (activity as MainActivity?)?.onSupportNavigateUp()

    }

    fun handleSendAdoptionRequest(){

        val pet = binding?.petSharedViewModel?.focusPet?.value;
        val account = binding?.accountSharedViewModel?.focusAccount?.value;
        val adoptionRequest = binding?.adoptionRequestSharedViewModel?.adoptionRequestCollection?.value;

        val _id = (adoptionRequest?.size ?: 0) + 1;
        val _adoptionRequest = AdoptionRequest( _id, account!!, pet!! )

        adoptionRequestSharedViewModelInternal.insertAdoptionRequestCollection(_adoptionRequest)

    }

}