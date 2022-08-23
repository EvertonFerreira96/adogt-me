package br.google.developer.adogtme.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.MainActivity
import br.google.developer.adogtme.R
import br.google.developer.adogtme.adapter.AdoptionRequestAdapter
import br.google.developer.adogtme.databinding.FragmentMyAdoptionRequestsBinding
import br.google.developer.adogtme.models.AdoptionRequest
import br.google.developer.adogtme.models.Pet
import br.google.developer.adogtme.views.AdoptionRequestViewModel
import br.google.developer.adogtme.views.PetViewModel

class MyAdoptionRequestsFragment : Fragment() {

    private var binding: FragmentMyAdoptionRequestsBinding? = null

    private val petSharedViewModelInternal: PetViewModel by activityViewModels()

    private val adoptionRequestSharedViewModelInternal: AdoptionRequestViewModel by activityViewModels()

    private lateinit var recyclerAdoptionRequestCard: RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding =  FragmentMyAdoptionRequestsBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    @SuppressLint("LongLogTag")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Adoption Request Card - Recycler */

      // Log.d("adoptionRequestSharedViewModelInternal", adoptionRequestSharedViewModelInternal.adoptionRequestCollection.value?.size.toString())

        recyclerAdoptionRequestCard = view.findViewById<RecyclerView>(R.id.recycler_adoption_request_card)

        recyclerAdoptionRequestCard.adapter = adoptionRequestSharedViewModelInternal.adoptionRequestCollection
            ?.let {
            it.value?.let {
                    _adoptions ->
                AdoptionRequestAdapter(context,
                    _adoptions.filter { _adoption -> _adoption?.active === true } as List<AdoptionRequest>,
                    this@MyAdoptionRequestsFragment) } }
        recyclerAdoptionRequestCard.setHasFixedSize(true)



        /* Binding */

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            adoptionRequestSharedViewModel = adoptionRequestSharedViewModelInternal
            fragment = this@MyAdoptionRequestsFragment
        }




    }

    fun handleRemovePetOnMyAdoptions(adoptionRequest: AdoptionRequest){
        adoptionRequestSharedViewModelInternal.adoptionRequestDelete(adoptionRequest)
        recyclerAdoptionRequestCard.adapter?.notifyDataSetChanged()
    }

    fun handleGoToPetDetails(pet: Pet){
        petSharedViewModelInternal.handleFocusPet(pet)
        findNavController().navigate(R.id.action_myAdoptionRequestsFragment_to_petDetailFragment)
    }

    fun goBack(){
        (activity as MainActivity?)?.onSupportNavigateUp()

    }

}