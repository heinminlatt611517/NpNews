package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.utils.LanguageUtils
import com.heinminlatt.npnews.utils.SessionManager
import com.heinminlatt.npnews.utils.langBURMESE
import com.heinminlatt.npnews.utils.langENGLISH
import kotlinx.android.synthetic.main.fragment_choose_lang_bottom_sheet.*


class ChooseLangBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_lang_bottom_sheet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        //radio group
        rb_group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_english -> {
                    Log.d("Radio Button", "English")
                    SessionManager.language = langENGLISH
                    activity?.let {
                        LanguageUtils.setLocale(langENGLISH, it)
                    }
                }
                R.id.rb_burmese -> {
                    Log.d("Radio Button", "Burmese")
                    SessionManager.language = langBURMESE
                    activity?.let {
                        LanguageUtils.setLocale(langBURMESE, it)
                    }
                }
            }
        }


    }


}