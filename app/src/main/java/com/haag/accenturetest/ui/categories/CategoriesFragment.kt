package com.haag.accenturetest.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.haag.accenturetest.R
import com.haag.accenturetest.model.Categories
import com.haag.accenturetest.util.lineDivider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_categories.*

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private val vm: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.categories)

        vm.getCategoriesDB().observe(viewLifecycleOwner, Observer {
            categoriesAdapter(it)
        })
    }

    private fun categoriesAdapter(list: List<Categories>) {
        categoriesRV.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = CategoriesAdapter(list) { category ->
                vm.navigateTo(requireView(), category)
            }
        }.lineDivider()

    }
}