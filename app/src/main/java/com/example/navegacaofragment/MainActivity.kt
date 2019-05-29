package com.example.navegacaofragment

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenu
import android.support.design.widget.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager
            .beginTransaction()
            .add(R.id.framePrincipal, FragmentA())
            .commit()

        findViewById<BottomNavigationView>(R.id.navegacao)
            .setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.itemA -> createFragment(FragmentA())
                    R.id.itemB -> createFragment(FragmentB())
                    R.id.itemC -> createFragment(FragmentC())
                    else -> false
                }
            }

    }

    private fun createFragment(f: android.support.v4.app.Fragment): Boolean {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framePrincipal, f)
            .addToBackStack(null)
            .commit()
        return true
    }
}
