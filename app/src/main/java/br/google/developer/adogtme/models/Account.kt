package br.google.developer.adogtme.models

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


enum class SexType {
    Male,
    Fermale,
}


@SuppressLint("SupportAnnotationUsage")
data class Sex(var id: Int, var sex: SexType, @StringRes var text: Int)

data class Account(private var _firstName: String, private var _lastName: String, private var _sex: SexType, private var _mail: String, private var _password: String, @DrawableRes private var _avatar: Int, private var _active: Boolean) {

    val firstName = _firstName;

    val lastName = _lastName;

    val sex = _sex;

    val mail = _mail;

    val password = _password;

    val avatar = _avatar;

    val active = _active

    fun handleLogin(){
        _active = true
    }

    fun handleLogout(){
        _active = false
    }
}