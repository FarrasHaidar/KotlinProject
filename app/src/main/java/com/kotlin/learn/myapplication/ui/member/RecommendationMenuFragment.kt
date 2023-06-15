package com.kotlin.learn.myapplication.ui.member

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.learn.myapplication.R
import com.kotlin.learn.myapplication.data.model.Menu
import com.kotlin.learn.myapplication.databinding.FragmentRecommendationMenuBinding
import com.kotlin.learn.myapplication.ui.adapter.RecoMenuAdapter


class RecommendationMenuFragment : Fragment() {
    private var _binding: FragmentRecommendationMenuBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuList = getListMenu()
        val adapter = RecoMenuAdapter(menuList)

        binding.rvMenu.apply {
            layoutManager = GridLayoutManager(context, 2) // Set grid layout with 2 columns
            this.adapter = adapter
        }
    }

    private fun getListMenu(): ArrayList<Menu> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.nama_menu)
        val dataPrice = resources.getStringArray(R.array.harga_menu)
        val listItem = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menuItem = Menu(dataPhoto.getResourceId(i, -1), dataName[i], dataPrice[i])
            listItem.add(menuItem)
        }
        return listItem
    }

}