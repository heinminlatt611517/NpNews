package com.heinminlatt.shared.activity

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.iid.FirebaseInstanceId
import com.heinminlatt.shared.R
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showSnackBar(message : String){
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }

     fun addReadMore(text: String, textView: TextView) {
        val ss = SpannableString(text.substring(0, 270) + "... read more")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadLess(text, textView)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = resources.getColor(R.color.colorPrimary, theme)
                } else {
                    ds.color = resources.getColor(R.color.colorPrimary)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
         textView.text = ss
         textView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun addReadLess(text: String, textView: TextView) {
        val ss = SpannableString("$text read less")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                addReadMore(text, textView)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ds.color = resources.getColor(R.color.colorPrimary, theme)
                } else {
                    ds.color = resources.getColor(R.color.colorPrimary)
                }
            }
        }
        ss.setSpan(clickableSpan, ss.length - 10, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}

    fun getFirebaseInstanceID() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("TOKEN", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                val msg = "token: $token"
                Log.d("TOKEN", msg)
                //Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            })
    }

      fun printHashKey(pContext: Context) {
        try {
            val info = pContext.packageManager.getPackageInfo(
                pContext.packageName,
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey = String(Base64.encode(md.digest(), 0))
                Log.d("Hash key", "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.d("", "printHashKey()", e)
        } catch (e: Exception) {
            Log.e("", "printHashKey()", e)
        }

    }
