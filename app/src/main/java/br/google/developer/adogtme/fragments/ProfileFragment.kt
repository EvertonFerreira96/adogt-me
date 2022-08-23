package br.google.developer.adogtme.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.google.developer.adogtme.MainActivity
import br.google.developer.adogtme.R
import br.google.developer.adogtme.databinding.FragmentProfileBinding
import br.google.developer.adogtme.views.AccountViewModel

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null

    private val accountSharedViewModelInternal: AccountViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentProfileBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            accountSharedViewModel = accountSharedViewModelInternal
            fragment = this@ProfileFragment
        }

        binding?.avatar?.setImageResource(
            accountSharedViewModelInternal.focusAccount.value?.avatar ?: R.drawable.ic_account_42dp
        )

    }

    fun handleSignOut(){
        accountSharedViewModelInternal.handleBlurAccount()
        Log.d("xxaaa", accountSharedViewModelInternal.accountCollection.value.toString())

        goBack()
    }

    fun handleGoToEditAccount(){
        findNavController().navigate(R.id.action_profileFragment_to_editAccountFragment)
    }



    fun handleGoToMyAdoptionRequests(){
        findNavController().navigate(R.id.action_profileFragment_to_myAdoptionRequestsFragment)
    }




    fun goBack(){
        (activity as MainActivity?)?.onSupportNavigateUp()

    }




}
