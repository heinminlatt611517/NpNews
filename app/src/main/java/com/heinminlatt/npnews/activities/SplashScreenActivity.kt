package com.heinminlatt.npnews.activities
import android.os.Bundle
import android.os.Handler
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.utils.SessionManager
import com.heinminlatt.npnews.utils.langBURMESE
import com.heinminlatt.npnews.utils.langENGLISH
import com.heinminlatt.shared.activity.BaseActivity
import java.util.*

class SplashScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        firstTimeCheckLanguage()

        Handler().postDelayed({

            startActivity(MainActivity.newIntent(this))
            finish()
        },1800)
    }

    private fun firstTimeCheckLanguage() {
        if(SessionManager.language == langENGLISH){
            setLocal(langENGLISH)
        }
        else {
            setLocal(langBURMESE)
        }
    }

    private fun setLocal(lang : String){
        val myLocale = Locale(lang)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
    }
}