package br.google.developer.adogtme.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.google.developer.adogtme.models.AdoptionRequest
import br.google.developer.adogtme.models.Pet

class AdoptionRequestViewModel: ViewModel() {
    private val _adoptionRequestCollection = MutableLiveData<MutableList<AdoptionRequest?>>();
    val adoptionRequestCollection: MutableLiveData<MutableList<AdoptionRequest?>> = _adoptionRequestCollection


    fun loadAdoptionRequestCollection(list: List<AdoptionRequest?>): List<AdoptionRequest?>? {
        _adoptionRequestCollection.value = list as MutableList<AdoptionRequest?>?
        return _adoptionRequestCollection.value
    }


    fun adoptionRequestDelete(_adoptionRequest: AdoptionRequest){
        _adoptionRequestCollection.value = _adoptionRequestCollection.value?.filter { it?.id !== _adoptionRequest.id } as MutableList<AdoptionRequest?>?
    }

    fun insertAdoptionRequestCollection(_data: AdoptionRequest){
        _adoptionRequestCollection.value = _adoptionRequestCollection.value?.plus(_data) as MutableList<AdoptionRequest?>?

    }
}