package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.HomeNewsActivity
import com.heinminlatt.npnews.adapters.HomeNewsAdapter
import com.heinminlatt.npnews.adapters.HomePagerAdapter
import com.heinminlatt.npnews.adapters.MainPagerAdapter
import com.heinminlatt.npnews.mvp.presenters.HomePresenter
import com.heinminlatt.npnews.mvp.presenters.impls.HomePresenterImpl
import com.heinminlatt.npnews.mvp.views.HomeView
import com.heinminlatt.npnews.utils.SessionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.pager
import kotlinx.android.synthetic.main.fragment_home.tabs


class HomeFragment : BaseFragment(),HomeView{
    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int): HomeFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = HomeFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mHomeNewsAdapter: HomeNewsAdapter
    private lateinit var mPresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Language", SessionManager.language.toString())
        setUpPresenter()
        //setUpRecyclerView()
        setUpTabViewWithViewPager()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_notification.setOnClickListener {
            startActivity(context?.let { HomeNewsActivity.newIntent(it) })
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun  setUpTabViewWithViewPager(){
        val pagerAdapter = activity?.let { HomePagerAdapter(it) }
        pager.adapter=pagerAdapter
        TabLayoutMediator(tabs,pager){tab, position ->
            when(position){
                0 -> { tab.text="Latest News"}
                1 -> {tab.text="Global News" }
                2 -> {tab.text="Local News"}
                3 -> {tab.text="Interview"}
            }

        }.attach()
    }


//    private fun setUpRecyclerView() {
//        rv_news.layoutManager =
//            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//        mHomeNewsAdapter = HomeNewsAdapter(mPresenter)
//        rv_news.adapter = mHomeNewsAdapter
//
//        mHomeNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
//        setUpRecyclerScrollState(rv_news)
//    }

    override fun navigateToNewsDetailScreen() {
        startActivity(context?.let { HomeNewsActivity.newIntent(it) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}