package com.example.fragmentcontainerview

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentcontainerview.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable

class MainActivity : AppCompatActivity() {

    var navController:NavController?=null

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        NavHostFragment
        var navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?

        navHostFragment?.let {
            navController = it.navController
            var bundle = Bundle()
            bundle.putString("MSG", "i am msg")
            bundle.putInt("NUM", 999)
            navController?.setGraph(R.navigation.nav_test, bundle)
        }


        binding.button3.setOnClickListener { Log.w("MYUTIL", "popBack = ${navController?.popBackStack()}") }

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.menu1->{
                    navController?.let {
                        var bundle = Bundle()
                        bundle.putString("MSG", "i am msg")
                        bundle.putInt("NUM", 777)
                        var pop = it.popBackStack(R.id.fragmentTrees, false)
                        Log.w("MYUTIL", "pop=${pop}")
                        if ( !pop )
                        {
                            it.navigate(R.id.fragmentTrees, bundle)
                        }
                    }
                    return@setOnItemSelectedListener true}
                R.id.menu2->{
                    navController?.let {
                        var bundle = Bundle()
                        bundle.putString("MSG", "i am msg")
                        bundle.putInt("NUM", 888)
                        var pop = it.popBackStack(R.id.fragmentTrees1, false)
                        Log.w("MYUTIL", "pop=${pop}")
                        if ( !pop)
                        {
                            it.navigate(R.id.fragmentTrees1, bundle)
                        }

                    }
                    return@setOnItemSelectedListener true}
                else->{
                    return@setOnItemSelectedListener false
                }
            }
        }

        binding.button.setOnClickListener {
            if ( binding.bottomNavigation.menu.findItem(R.id.menu1).isVisible )
            {
                binding.bottomNavigation.menu.findItem(R.id.menu1).isVisible = false
            }
            else
            {
                binding.bottomNavigation.menu.findItem(R.id.menu1).isVisible = true
            }
        }

        val badge = binding.bottomNavigation.getOrCreateBadge(R.id.menu1)
        badge.backgroundColor = Color.RED
        badge.number = 100
        badge.maxCharacterCount = 3

        val badge1 = binding.bottomNavigation.getOrCreateBadge(R.id.menu2)
        badge1.backgroundColor = Color.YELLOW
        badge1.number = 99
        badge1.badgeTextColor = Color.BLACK
        badge1.maxCharacterCount = 3
        badge1.badgeGravity = BadgeDrawable.TOP_START


        binding.button1.setOnClickListener {
            if ( badge.isVisible)
            {
                badge.isVisible = false
            }
            else
            {
                badge.isVisible = true
            }
        }

//        val transaction = supportFragmentManager.beginTransaction()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val currentNightMode = newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when(currentNightMode)
        {
            Configuration.UI_MODE_NIGHT_YES->{

            }
            Configuration.UI_MODE_NIGHT_NO->{

            }
        }
        binding.button1.setTextColor(ContextCompat.getColor(this, R.color.text))
    }

}