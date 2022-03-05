package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.activities.EditProfileActivity
import com.heinminlatt.npnews.activities.MainActivity
import com.heinminlatt.npnews.mvp.presenters.AccountPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.AccountPresenterImpl
import com.heinminlatt.npnews.mvp.views.AccountView
import com.heinminlatt.npnews.utils.SessionManager
import com.heinminlatt.npnews.utils.langENGLISH
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_artical.*
import kotlinx.android.synthetic.main.fragment_choose_lang_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_home.*

class AccountFragment : BaseFragment() , AccountView{
    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : AccountFragment {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = AccountFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    private lateinit var mPresenter : AccountPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Language",SessionManager.language.toString())

        setUpPresenter()
        setUpActionListener()
    }


    private fun setUpActionListener() {
        iv_editUserAccount.setOnClickListener {
            mPresenter.onTapEdit()
        }

        btn_signOut.setOnClickListener {
            mPresenter.onTapSignOut()
        }

        iv_chooseLang.setOnClickListener {
            val bottomSheetDialogFragment = ChooseLangBottomSheetFragment()
            activity?.supportFragmentManager?.let { it1 ->
                bottomSheetDialogFragment.show(it1, bottomSheetDialogFragment.tag)
            }

        }

        if(SessionManager.language == langENGLISH){
            iv_chooseLang.setImageResource(R.drawable.eng)
        }
        else {
            iv_chooseLang.setImageResource(R.drawable.my)
        }

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(AccountPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToEditProfileScreen() {
        startActivity(context?.let { EditProfileActivity.newIntent(it) })
    }

    override fun showLogoutDialog() {
        logOutDialog()
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}