package com.heinminlatt.shared.fragment
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BaseFragment : Fragment() {

    fun showSnackbar(message : String){
        activity?.window?.decorView?.let { Snackbar.make(it,message,Snackbar.LENGTH_LONG).show() }
    }



}