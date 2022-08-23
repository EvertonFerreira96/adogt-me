package br.google.developer.adogtme.models

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.IntOffset
import androidx.constraintlayout.helper.widget.MotionEffect.EAST
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

enum class PetAttributeKeyType {
    EnergyLevel,
    Friendliness,
    Playfulness,
    Watchfulness,
}

enum class PetTypeType {
    Cat,
    Dog,
    Panda,
    Rabbit,
    Seagull,
    Mouse,
    Elephant,
}



data class PetFilter(var type: PetTypeType, @DrawableRes val avatar: Int, var active: Boolean);

data class OwnerPet(var name: String, @DrawableRes val avatar: Int);

data class PetAttribute(var key: PetAttributeKeyType, var value: Int);

const val TAG = "PetClass"

data class Pet(private var _city: String,private var _type: PetTypeType, private var _firstname: String, private var _lastname: String, private var _age: Int, private var _description: String, private var _disclaimer: String, @DrawableRes private var _avatar: Int, private var _attrs: MutableList<PetAttribute>, private var _ownerPet: OwnerPet, private var _active: MutableLiveData<Boolean>) {

    val city = _city;

    val type = _type;

    val firstname = _firstname;

    val lastname = _lastname;

    val age = _age;

    val description = _description;

    val disclaimer = _disclaimer

    @DrawableRes val avatar = _avatar;

    val attrs: List<PetAttribute> = _attrs;

    val ownerPet = _ownerPet;

    val active: LiveData<Boolean> = _active;


    fun handleToggleActive(value: Boolean) {
        _active.value = value
    }

    fun addAttribute(data: PetAttribute){
        _attrs.add(data)
    }

}