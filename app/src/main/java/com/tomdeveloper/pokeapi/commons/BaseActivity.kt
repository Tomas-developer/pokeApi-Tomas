package com.tomdeveloper.pokeapi.commons

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(){

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

}