package com.kotlin.learn.myapplication.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kotlin.learn.myapplication.R
import com.kotlin.learn.myapplication.data.viewmodel.AuthViewModel
import com.kotlin.learn.myapplication.data.viewmodel.SettingViewModel
import com.kotlin.learn.myapplication.data.viewmodel.ViewModelGeneralFactory
import com.kotlin.learn.myapplication.data.viewmodel.ViewModelSettingFactory
import com.kotlin.learn.myapplication.databinding.FragmentLoginBinding
import com.kotlin.learn.myapplication.utils.Constanta
import com.kotlin.learn.myapplication.utils.Helper
import com.kotlin.learn.myapplication.utils.SettingPreferences
import com.kotlin.learn.myapplication.utils.dataStore


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var viewModel: AuthViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val rootView = binding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = SettingPreferences.getInstance((activity as AuthActivity).dataStore)
        val settingViewModel =
            ViewModelProvider(this, ViewModelSettingFactory(pref))[SettingViewModel::class.java]
        viewModel = ViewModelProvider(
            this,
            ViewModelGeneralFactory((activity as AuthActivity))
        )[AuthViewModel::class.java]
        viewModel?.let { vm ->
            vm.loginResult.observe(viewLifecycleOwner) { login ->
                // success login process triggered -> save preferences
                settingViewModel.setUserPreferences(
                    login.loginResult.token,
                    login.loginResult.userId,
                    login.loginResult.name,
                    viewModel!!.tempEmail.value ?: Constanta.preferenceDefaultValue
                )
            }
            vm.error.observe(viewLifecycleOwner) { error ->
                if (error.isNotEmpty()) {
                    Helper.showDialogInfo(requireContext(), error)
                }
            }
            vm.loading.observe(viewLifecycleOwner) { state ->
                binding.root.visibility = state
            }
        }
        settingViewModel.getUserPreferences(Constanta.UserPreferences.UserToken.name)
            .observe(viewLifecycleOwner) { token ->
                // token changes -> redirect to Main Activity
                if (token != Constanta.preferenceDefaultValue) (activity as AuthActivity).routeToMainActivity()
            }
        binding.btnAction.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()
            when {
                email.isEmpty() or password.isEmpty() -> {
                    Helper.showDialogInfo(
                        requireContext(),
                        getString(R.string.UI_validation_empty_email_password)
                    )
                }
                !email.matches(Constanta.emailPattern) -> {
                    Helper.showDialogInfo(
                        requireContext(),
                        getString(R.string.UI_validation_invalid_email)
                    )
                }
                password.length <= 6 -> {
                    Helper.showDialogInfo(
                        requireContext(),
                        getString(R.string.UI_validation_password_rules)
                    )
                }
                else -> {
                    viewModel?.login(email, password)
                }
            }
        }
        binding.btnRegister.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, RegisterFragment(), RegisterFragment::class.java.simpleName)
                /* shared element transition to main activity */
                addSharedElement(binding.labelAuth, "auth")
                addSharedElement(binding.edEmail, "email")
                addSharedElement(binding.edPassword, "password")
                addSharedElement(binding.containerMisc, "misc")
                commit()

        binding.tvDirectRegister.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}