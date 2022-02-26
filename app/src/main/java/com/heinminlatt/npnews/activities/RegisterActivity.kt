package com.heinminlatt.npnews.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.mvp.presenters.LoginPresenter
import com.heinminlatt.npnews.mvp.presenters.RegisterPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.LoginPresenterImpl
import com.heinminlatt.npnews.mvp.presenters.impls.RegisterPresenterImpl
import com.heinminlatt.npnews.mvp.views.RegisterView
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(),RegisterView {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private lateinit var mPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        tv_login.setOnClickListener {
            mPresenter.onTapLogin()
        }

        iv_back.setOnClickListener {
            mPresenter.onTapBackArrow()
        }
    }


    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(this.let { LoginActivity.newIntent(it) })
        finish()
    }

    override fun showErrorMessage(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun onBackPressed() {
        startActivity(this.let { LoginActivity.newIntent(it) })
        super.onBackPressed()
    }
}