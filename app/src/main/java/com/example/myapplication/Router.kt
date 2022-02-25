package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Router {
    private var container: Int = -1
    private lateinit var fm: FragmentManager
    private lateinit var finish: () -> Unit

    fun init(container: Int, fm: FragmentManager, finish: () -> Unit) {
        this.container = container
        this.fm = fm
        this.finish = finish
    }


    fun navigateTo(fragment: Fragment) {
        fm
            .beginTransaction()
            .replace(container, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun backTo(tag: String) {
        fm.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun onBackPressed() {
        if (fm.backStackEntryCount == 1)
            finish()
        else
            fm.popBackStack()
    }
}