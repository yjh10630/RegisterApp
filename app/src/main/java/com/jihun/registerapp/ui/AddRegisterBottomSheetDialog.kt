package com.jihun.registerapp.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jihun.registerapp.R
import com.jihun.registerapp.databinding.FragmentAddRegisterBinding

class AddRegisterBottomSheetDialog: BottomSheetDialogFragment() {

    companion object {
        fun newInstance(): AddRegisterBottomSheetDialog =
            AddRegisterBottomSheetDialog().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private val binding by viewBinding(FragmentAddRegisterBinding::bind)

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        dialog.setOnShowListener { setupBottomSheet(it) }
    }

    private fun setupBottomSheet(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        bottomSheetDialog.setCanceledOnTouchOutside(false)  // outside Touch Dismiss Disable
        val bottomSheet = bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet)
        bottomSheet?.setBackgroundColor(Color.TRANSPARENT) ?: run { dismiss() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_add_register, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with (binding) {
            check.setOnClickListener {
                if (nameEdit.text?.trim()?.isEmpty() == true) {
                    nameLayer.isErrorEnabled = true
                    nameLayer.error = "이름을 입력해 주세요."
                    nameEdit.text?.clear()
                } else {
                    dismiss()
                }
            }

            nameEdit.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) { }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    s?.let {
                        when (it.isEmpty()) {
                            true -> {  }
                            false -> {
                                nameLayer.error = ""
                                nameLayer.isErrorEnabled = false
                            }
                        }
                    }
                }
            })
        }


    }
}