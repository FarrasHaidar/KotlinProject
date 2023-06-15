package com.kotlin.learn.myapplication.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.learn.myapplication.R
import com.kotlin.learn.myapplication.data.model.Menu

class DetailMenuFragment : Fragment() {
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            menu = it.getParcelable(KEY) ?: Menu(0, "", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_menu, container, false)

        // Update UI with menu data
        // Example: view.findViewById<TextView>(R.id.tv_menu_name).text = menu.namaMenu

        return view
    }

    companion object {
        private const val KEY = "Makanan"

        fun newInstance(menu: Menu): DetailMenuFragment {
            val fragment = DetailMenuFragment()
            val args = Bundle()
            args.putParcelable(KEY, menu)
            fragment.arguments = args
            return fragment
        }
    }
}