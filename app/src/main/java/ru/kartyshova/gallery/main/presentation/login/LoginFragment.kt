package ru.kartyshova.gallery.main.presentation.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.navigation.fragment.findNavController
import com.redmadrobot.inputmask.MaskedTextChangedListener
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kartyshova.gallery.R
import ru.kartyshova.gallery.databinding.LoginLayoutBinding

class LoginFragment : Fragment(R.layout.login_layout) {

    private var binding: LoginLayoutBinding? = null

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.also {
            binding = LoginLayoutBinding.bind(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MaskedTextChangedListener.installOn(
            binding?.login ?: return,
            "+7 ([000]) [000]-[00]-[00]",
            object : MaskedTextChangedListener.ValueListener {
                override fun onTextChanged(
                    maskFilled: Boolean,
                    extractedValue: String,
                    formattedValue: String
                ) {
                    viewModel.updatePhone(extractedValue)
                }
            }
        )

        binding?.password?.addTextChangedListener {
            viewModel.updatePassword(it?.toString() ?: "")
        }

        binding?.enterBtn?.setOnClickListener {
            viewModel.login()
            binding?.progressLoading?.isVisible = true
        }

        lifecycleScope.launchWhenStarted {
            viewModel.auth.collect {
                if (it) {
                    val action = LoginFragmentDirections.actionLoginFragmentToGalleryFragment()
                    findNavController().navigate(action)
                }
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
