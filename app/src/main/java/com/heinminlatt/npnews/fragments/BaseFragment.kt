package com.heinminlatt.npnews.fragments
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.heinminlatt.npnews.activities.MainActivity
import kotlinx.android.synthetic.main.activity_main.*


open class BaseFragment : Fragment() {
    fun showSnackBar(message : String){
        activity?.window?.decorView?.let { Snackbar.make(it,message,Snackbar.LENGTH_LONG).show() }
    }

    fun setUpRecyclerScrollState(rv_news : RecyclerView) {
        rv_news.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(@NonNull recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCREEN_STATE_OFF) {
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                }
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    // Scrolling up
                    (activity as MainActivity).cardView.visibility = View.GONE
                } else {
                    // Scrolling down
                    (activity as MainActivity).cardView.visibility = View.VISIBLE
                }
            }
        })
    }

}