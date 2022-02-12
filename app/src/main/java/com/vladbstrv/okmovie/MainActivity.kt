package com.vladbstrv.okmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vladbstrv.okmovie.screens.googlemaps.MapsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_screen_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_maps -> {
            supportFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(R.id.containerView, MapsFragment())
                .commitAllowingStateLoss()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}