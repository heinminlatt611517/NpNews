package com.heinminlatt.npnews.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.mvp.presenters.LoginPresenter
import com.heinminlatt.npnews.mvp.presenters.impls.LoginPresenterImpl
import com.heinminlatt.npnews.mvp.views.LoginView
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),LoginView {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        tv_register.setOnClickListener {
            mPresenter.onTapRegister()
        }

        iv_back.setOnClickListener {
            mPresenter.onTapBackArrow()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToRegisterScreen() {
        startActivity(this.let { RegisterActivity.newIntent(it) })
        finish()
    }

    override fun navigateToPreviousScreen() {
        finish()
    }

    override fun showErrorMessage(errorMessage: String) {

    }
}