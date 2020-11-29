package com.shameem.projectstructure.ui.home

import com.shameem.projectstructure.R
import com.shameem.projectstructure.base.BaseActivity
import com.shameem.projectstructure.utils.replaceFragment

class HomeActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_home


    override val setToolbar: Boolean
        get() = true
    override val hideStatusBar: Boolean
        get() = false


    override fun initData() {
        fragmentLaunch()
    }

    override fun fragmentLaunch() {
        replaceFragment(fragment = HomeFragment())

    }

    override fun setupUI() {

    }

    override fun setupViewModel() {

    }

    override fun setupObserver() {

    }

    override fun onClicks() {

    }


}