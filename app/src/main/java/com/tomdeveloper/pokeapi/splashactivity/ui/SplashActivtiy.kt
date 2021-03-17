package com.tomdeveloper.pokeapi.splashactivity.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseActivity
import com.tomdeveloper.pokeapi.home_activity.HomeActivity

class SplashActivtiy: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity
        )

        object: Thread(){
            override fun run() {
                super.run()
                sleep(2000)
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
        }.start()
    }
}