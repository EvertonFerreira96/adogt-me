package br.google.developer.adogtme.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.annotation.DrawableRes
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.google.developer.adogtme.MainActivity
import br.google.developer.adogtme.R
import br.google.developer.adogtme.data.Datasource
import br.google.developer.adogtme.databinding.FragmentAccountBinding
import br.google.developer.adogtme.models.Account
import br.google.developer.adogtme.models.Sex
import br.google.developer.adogtme.models.SexType
import br.google.developer.adogtme.views.AccountViewModel

class AccountFragment : Fragment() {

    private var binding: FragmentAccountBinding? = null
    private var radioButtonSexTypeValue = 1;
    private val accountSharedViewModelInternal: AccountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentAccountBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        handleCreateSexRadioButtons(Datasource().loadSex());
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            accountSharedViewModel = accountSharedViewModelInternal
            fragment = this@AccountFragment
        }

    }



    fun handleCreateSexRadioButtons(data: List<Sex>){
        data.forEach {
            sex ->
            var rdx = RadioButton(this.context)
            rdx.id = View.generateViewId()
            rdx.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            rdx.setOnClickListener {
                handleChangedSexRadioButton(sex, rdx)
            }
            rdx.setText(sex.text)

            binding?.rdgSex?.addView(rdx)
            if(sex.id === radioButtonSexTypeValue)
                binding?.rdgSex?.check(rdx.id);


        }
    }

    fun handleChangedSexRadioButton(sex: Sex, rdx: RadioButton){
        if(rdx.isChecked){
            radioButtonSexTypeValue = sex.id
        }
    }


    @SuppressLint("SupportAnnotationUsage")
    fun handleSignUpRegistry(){

        var _firstName = binding?.inputFirstname?.text.toString()
        var _lastName = binding?.inputLastname?.text.toString()
        var _mail = binding?.inputMail?.text.toString()
        var _password = binding?.inputPassword?.text.toString()

        var _sex: SexType;
        @DrawableRes var _avatar: Int;


        when(radioButtonSexTypeValue){
            1 -> {
                _sex = SexType.Male
                _avatar = R.drawable.men
            }
            2 -> {
                _sex = SexType.Fermale
                _avatar = R.drawable.woman
            }
           else -> {
               return
           }
       }

        val _account = Account(_firstName,
            _lastName,
            _sex,
            _mail,
            _password,
            _avatar,
            true)

        accountSharedViewModelInternal.insertAccountCollection(_account)
        accountSharedViewModelInternal.handleFocusAccount(_account)
        goBack()
    }

    fun handleGoToSignIn(){
        findNavController().navigate(R.id.action_accountFragment_to_loginInFragment)
    }


    fun goBack(){
        (activity as MainActivity?)?.onSupportNavigateUp()

    }




}
