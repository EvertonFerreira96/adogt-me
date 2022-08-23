package br.google.developer.adogtme

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import br.google.developer.adogtme.data.Datasource
import br.google.developer.adogtme.models.Account
import br.google.developer.adogtme.views.AccountViewModel
import br.google.developer.adogtme.views.AdoptionRequestViewModel
import br.google.developer.adogtme.views.PetViewModel


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    private val accountSharedViewModelInternal: AccountViewModel by viewModels()

    private val petSharedViewModelInternal: PetViewModel by viewModels()


    private val adoptionRequestSharedViewModelInternal: AdoptionRequestViewModel by viewModels()



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setActionBarSettings();
        accountSharedViewModelInternal.loadAccountCollection(Datasource().loadAccounts() as MutableList<Account>)
        petSharedViewModelInternal.loadPetFilterCollection(Datasource().loadPetFilters())
        petSharedViewModelInternal.loadPetCollection(Datasource().loadPets())
        adoptionRequestSharedViewModelInternal.loadAdoptionRequestCollection(Datasource().loadAdoptionRequests())
    }

    @SuppressLint("ResourceAsColor")
    private fun setActionBarSettings(){

        // Retrieve NavController from the NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Set up the action bar for use with the NavController

        supportActionBar?.hide();
        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
