package br.google.developer.adogtme.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import br.google.developer.adogtme.R
import br.google.developer.adogtme.models.*

class AccountViewModel: ViewModel() {
    private val _focusAccount = MutableLiveData<Account?>();
    val focusAccount: LiveData<Account?> = _focusAccount

    private val _accountCollection = MutableLiveData<MutableList<Account>?>()
    val accountCollection: LiveData<MutableList<Account>?> = _accountCollection

    fun loadAccountCollection(list: MutableList<Account>): MutableList<Account> {
        _accountCollection.value = list as MutableList<Account>
        return _accountCollection.value!!
    }


    fun insertAccountCollection(_account: Account){
         _accountCollection.value = _accountCollection.value?.plus(_account) as MutableList<Account>?
    }

    fun handleFocusAccount(_data: Account) {
        _accountCollection.value?.forEach { if(it.mail == _data.mail) it.handleLogin() else it.handleLogout() }
        _focusAccount.value = _data
    }

    fun handleBlurAccount() {
        _focusAccount.value = null
    }

}