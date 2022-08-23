package br.google.developer.adogtme.fragments

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.google.developer.adogtme.MainActivity
import br.google.developer.adogtme.R
import br.google.developer.adogtme.databinding.FragmentLoginInBinding
import br.google.developer.adogtme.models.Account
import br.google.developer.adogtme.models.SexType
import br.google.developer.adogtme.views.AccountViewModel


class LoginInFragment : Fragment() {
    private var binding: FragmentLoginInBinding? = null
    private var radioButtonSexTypeValue = 1;
    private val accountSharedViewModelInternal: AccountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentLoginInBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            accountSharedViewModel = accountSharedViewModelInternal
            fragment = this@LoginInFragment
        }

    }



    @SuppressLint("SupportAnnotationUsage", "SetTextI18n")
    fun handleSignInRegistry(){

        var _mail = binding?.inputMail?.text.toString()
        var _password = binding?.inputPassword?.text.toString()

        var _sex: SexType;
        @DrawableRes var _avatar: Int;

        val account = accountSharedViewModelInternal.accountCollection.value?.find { it.mail == _mail }


        if(account == null){
            binding?.errorMessage?.text = getString(R.string.account_not_found)
            binding?.errorMessage?.visibility = View.VISIBLE
            return
        }
        if(account?.password != _password){
            binding?.errorMessage?.text = getString(R.string.password_not_found)
            binding?.errorMessage?.visibility = View.VISIBLE
            return
        }

        accountSharedViewModelInternal.handleFocusAccount(account)
        findNavController().navigate(R.id.action_loginInFragment_to_petCollectionFragment)

    }

    fun goBack(){
        (activity as MainActivity?)?.onSupportNavigateUp()

    }



}