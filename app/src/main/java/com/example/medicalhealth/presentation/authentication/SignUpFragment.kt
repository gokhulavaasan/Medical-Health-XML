package com.example.medicalhealth.presentation.authentication

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.medicalhealth.R
import androidx.navigation.fragment.findNavController
import com.example.medicalhealth.databinding.FragmentSignUpBinding



class SignUpFragment : Fragment() {


    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        logINClicked()
    }

    private fun logINClicked() {
        val textView = binding.loginBtn
        val fullText = "Already have an account? Log in"
        val spannable = SpannableString(fullText)

        val clickableText = "Log in"
        val startIndex = fullText.indexOf(clickableText)
        val endIndex = startIndex + clickableText.length

        // Make "Log in" clickable
        spannable.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(requireContext(), R.color.primary)
                ds.isFakeBoldText = true
                ds.isUnderlineText = false // remove underline
            }
        }, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Apply clickable text
        textView.text = spannable
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.highlightColor = Color.TRANSPARENT

    }
}