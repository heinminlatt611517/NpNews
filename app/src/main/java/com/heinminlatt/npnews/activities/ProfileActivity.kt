package com.heinminlatt.npnews.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.npnews.R
import com.heinminlatt.shared.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {

    companion object{
        fun newIntent(context : Context) : Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_editUserAccount.setOnClickListener {
            startActivity(this.let { EditProfileActivity.newIntent(it) })
        }
    }
}