package br.google.developer.adogtme.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.google.developer.adogtme.R
import br.google.developer.adogtme.adapter.PetCardAdapter
import br.google.developer.adogtme.adapter.PetItemFilterAdapter
import br.google.developer.adogtme.databinding.FragmentPetCollectionBinding
import br.google.developer.adogtme.models.Pet
import br.google.developer.adogtme.models.PetFilter
import br.google.developer.adogtme.views.AccountViewModel
import br.google.developer.adogtme.views.PetViewModel

const val TAG = "PetCollectionFragment";

class PetCollectionFragment : Fragment() {
    private var binding: FragmentPetCollectionBinding? = null

    private val accountSharedViewModelInternal: AccountViewModel by activityViewModels()

    private val petSharedViewModelInternal: PetViewModel by activityViewModels()


    private lateinit var recyclerPetCard: RecyclerView;

    private lateinit var recyclerPetFilterCard: RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding =  FragmentPetCollectionBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onResume() {
        binding?.notifyChange()
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /* Pet Card - Recycler */

        recyclerPetCard = view.findViewById<RecyclerView>(R.id.recycler_pet_card)


        recyclerPetCard.adapter =  PetCardAdapter(context, petSharedViewModelInternal.petCollection.value as MutableList<Pet>, this@PetCollectionFragment)

        recyclerPetCard.setHasFixedSize(true)



        /* Pet Filter Card - Recycler */

        recyclerPetFilterCard = view.findViewById<RecyclerView>(R.id.recycler_pet_filter)

        recyclerPetFilterCard.adapter = petSharedViewModelInternal.
                                            petFilterCollection?.let {
                                                    it.value?.let {
                                                            _petFilters ->
                                                                PetItemFilterAdapter(context,
                                                                                     _petFilters,
                                                                            this@PetCollectionFragment) } }

        recyclerPetFilterCard.setHasFixedSize(true)

        /* Binding */

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            accountSharedViewModel = accountSharedViewModelInternal
            petSharedViewModel = petSharedViewModelInternal
            fragment = this@PetCollectionFragment
        }

        binding?.name?.text = if (accountSharedViewModelInternal.focusAccount.value?.firstName != null)  accountSharedViewModelInternal.focusAccount.value?.firstName.toString() + ' ' + accountSharedViewModelInternal.focusAccount.value?.lastName.toString()
        else getString(R.string.Enter)

        binding?.avatar?.setImageResource(
                accountSharedViewModelInternal.focusAccount.value?.avatar ?: R.drawable.ic_account_42dp
            )
    }

    fun handleGoLogin(){
        if (accountSharedViewModelInternal.focusAccount.value?.mail !== null)
            findNavController().navigate(R.id.action_petCollectionFragment_to_profileFragment)
            else
            findNavController().navigate(R.id.action_petCollectionFragment_to_accountFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun handleGoToPetDetails(pet: Pet){
        petSharedViewModelInternal.handleFocusPet(pet)
        findNavController().navigate(R.id.action_petCollectionFragment_to_petDetailFragment)
    }

    fun handleFilterPet(item: PetFilter){
        petSharedViewModelInternal.handleTooglePetFilter(item, !item.active)
        recyclerPetCard.adapter?.notifyDataSetChanged()
        recyclerPetFilterCard.adapter?.notifyDataSetChanged()
    }

}

