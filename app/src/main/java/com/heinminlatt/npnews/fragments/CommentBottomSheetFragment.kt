package com.heinminlatt.npnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heinminlatt.npnews.R
import com.heinminlatt.npnews.adapters.ArticleNewsAdapter
import com.heinminlatt.npnews.adapters.CommentMessageAdapter
import com.heinminlatt.npnews.adapters.GlobalNewsAdapter
import kotlinx.android.synthetic.main.fragment_artical.*
import kotlinx.android.synthetic.main.fragment_comment_bottom_sheet.*


class CommentBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var mCommentMessageAdapter: CommentMessageAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comment_bottom_sheet, container, false)

    }

    override fun onStart() {
        super.onStart()
        dialog?.also {
            val bottomSheet = dialog!!.findViewById<View>(R.id.design_bottom_sheet)
            bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            val behavior = BottomSheetBehavior.from<View>(bottomSheet)
            behavior.peekHeight = resources.displayMetrics.heightPixels //replace to whatever you want
            view?.requestLayout()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        rv_commentMessage.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mCommentMessageAdapter = CommentMessageAdapter()
        rv_commentMessage.adapter = mCommentMessageAdapter

        mCommentMessageAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9))
    }

}