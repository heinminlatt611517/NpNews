package com.heinminlatt.npnews.fragments
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.log_out_dialog.view.*


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

    fun logOutDialog() : Any{
        val mDialogView = LayoutInflater.from(activity).inflate(R.layout.log_out_dialog, null)
        val mBuilder = activity?.let {
            AlertDialog.Builder(it)
                .setView(mDialogView)
        }

        val mAlertDialog = mBuilder?.show()

        mDialogView.btn_cancel.setOnClickListener {
            mAlertDialog?.dismiss()
        }
        mDialogView.btn_ok.setOnClickListener {
            activity?.finish()
            val mainIntent = Intent(activity, MainActivity::class.java)
            startActivity(mainIntent)
        }
        return mAlertDialog as AlertDialog

    }

}