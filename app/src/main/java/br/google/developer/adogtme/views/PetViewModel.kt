package br.google.developer.adogtme.views
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.google.developer.adogtme.models.*

class PetViewModel: ViewModel() {
    private val _focusPet = MutableLiveData<Pet?>();
    val focusPet: LiveData<Pet?> = _focusPet

    private val _petCollection = MutableLiveData<MutableList<Pet>?>()
    val petCollection: LiveData<MutableList<Pet>?> = _petCollection

    private val _petFilterCollection = MutableLiveData<MutableList<PetFilter>?>()
    val petFilterCollection: LiveData<MutableList<PetFilter>?> = _petFilterCollection



    fun loadPetCollection(list: List<Pet?>?): List<Pet?>? {
        _petCollection.value = list as MutableList<Pet>?
        return _petCollection.value
    }

    fun loadPetFilterCollection(list: List<PetFilter?>?): List<PetFilter?>? {
        _petFilterCollection.value = list as MutableList<PetFilter>?
        return _petFilterCollection.value
    }


    fun handleFocusPet(pet: Pet): Pet {
        _focusPet.value = pet
        return _focusPet.value!!;
    }

    fun handleBlurPet() {
        _focusPet.value = null
    }


    fun handleTooglePetFilter(item: PetFilter, active: Boolean) {
        item.active = active;
        _petFilterCollection.value = _petFilterCollection.value?.map { if (it.type.name === item.type.name) item else it } as MutableList<PetFilter>?
        _petCollection.value = _petCollection.value?.map { validIfPetInPetTypeFilter(it) } as MutableList<Pet>?
    }

    fun validIfPetInPetTypeFilter(_pet: Pet): Pet{
        val allCleanFilters = _petFilterCollection.value?.filter { it.active }?.size ?: 0;
        val check = _petFilterCollection.value?.find {
            it.type.name === _pet.type.name && it.active
        }

        _pet.handleToggleActive((allCleanFilters === 0) || (check != null))

        return _pet
    }
 }



