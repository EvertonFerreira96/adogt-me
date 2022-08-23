package br.google.developer.adogtme.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant

data class AdoptionRequest(private var _id: Int, private var _account: Account, private var _pet: Pet){
    val id = _id
    val account = _account
    val pet = _pet
    @RequiresApi(Build.VERSION_CODES.O)
    val timestamp = Instant.now()!!
    private var _active = true
    val active = _active

    fun delete(){
        _active = false
    }

}