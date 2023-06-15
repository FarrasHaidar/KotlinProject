package com.kotlin.learn.myapplication.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.learn.myapplication.R
import com.kotlin.learn.myapplication.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val rootView = binding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tambahkan logika untuk tombol "Register" di sini
        binding.btnActionSignUp.setOnClickListener {
            // Lakukan tindakan saat tombol "Register" ditekan
            // Contoh: Validasi input, panggil metode registrasi API, dll.
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}