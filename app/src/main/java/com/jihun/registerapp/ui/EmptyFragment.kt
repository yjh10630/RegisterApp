package com.jihun.registerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jihun.registerapp.R
import com.jihun.registerapp.databinding.FragmentEmptyBinding

class EmptyFragment : Fragment() {

    private val binding by viewBinding(FragmentEmptyBinding::bind)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_empty, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.img.setOnClickListener {
            AddRegisterBottomSheetDialog.newInstance().also {
                it.show(childFragmentManager, it.tag)
            }
        }
    }
}