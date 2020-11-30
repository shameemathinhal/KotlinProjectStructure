package com.shameem.projectstructure.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shameem.projectstructure.R
import com.shameem.projectstructure.base.BaseFragment
import com.shameem.projectstructure.data.api.ApiHelperImpl
import com.shameem.projectstructure.data.api.RetrofitBuilder
import com.shameem.projectstructure.utils.Animations
import com.shameem.projectstructure.utils.Status
import com.shameem.projectstructure.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun setView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }


    override fun initData() {

    }

    override fun setupUI() {

    }

    override fun setupViewModel() {
        homeViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService), requireActivity()
            )
        ).get(HomeViewModel::class.java)
    }

    override fun setupObserver() {
        homeViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> TODO()
                Status.ERROR -> TODO()
                Status.LOADING -> TODO()
                Status.NO_INTERNET -> TODO()
                Status.DATA_EMPTY -> TODO()

            }
        })
    }

    override fun onClicks() {
        tvSample.setOnClickListener {

        }
    }


}