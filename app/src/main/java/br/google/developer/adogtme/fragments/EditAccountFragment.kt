package br.google.developer.adogtme.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
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
import br.google.developer.adogtme.databinding.FragmentEditAccountBinding
import br.google.developer.adogtme.models.Account
import br.google.developer.adogtme.models.Sex
import br.google.developer.adogtme.models.SexType
import br.google.developer.adogtme.views.AccountViewModel

class EditAccountFragment : Fragment() {

    private var binding: FragmentEditAccountBinding? = null
    private val accountSharedViewModelInternal: AccountViewModel by activityViewModels()
    private var radioButtonSexTypeValue = 1 // accountSharedViewModelInternal.focusAccount.value?.sex ?: 0;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentEditAccountBinding.inflate(inflater, container, false)
        binding = fragmentBinding


        handleCreateSexRadioButtons(Datasource().loadSex());
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            accountSharedViewModel = accountSharedViewModelInternal
            fragment = this@EditAccountFragment
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

             val currentSexValue = Datasource().loadSex().find { it.sex.toString() === accountSharedViewModelInternal.focusAccount.value?.sex?.toString() }

            if(sex.id === currentSexValue?.id ?: radioButtonSexTypeValue)
                binding?.rdgSex?.check(rdx.id);


        }
    }

    fun handleChangedSexRadioButton(sex: Sex, rdx: RadioButton){
        if(rdx.isChecked){
            radioButtonSexTypeValue = sex.id
        }
    }


    @SuppressLint("SupportAnnotationUsage")
    fun handleEditAccount(){

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

        accountSharedViewModelInternal.handleFocusAccount(_account)
        accountSharedViewModelInternal.insertAccountCollection(_account)
        goBack()
    }

    fun goBack(){
        (activity as MainActivity?)?.onSupportNavigateUp()

    }




}
