package com.tomdeveloper.pokeapi.home_activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseActivity
import com.tomdeveloper.pokeapi.home_activity.trainerProfile.ui.TakePhotoProfileFragment
import java.io.File

class HomeActivity : BaseActivity() {

    companion object {
        const val REQUEST_CODE_PERMISSIONS = 10
        val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.itemIconTintList = null
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_entrenador
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            var perGgranted = ContextCompat
                    .checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
            if (perGgranted) {
                Toast.makeText(this,
                        "Permisos concedidos, ya puedes sarte una foto de perfil.",
                        Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,
                        "Debes de dar permisos a la cámara para poder sacarte una foto.",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }


}