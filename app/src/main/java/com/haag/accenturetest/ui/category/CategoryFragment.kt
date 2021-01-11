package com.haag.accenturetest.ui.category

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.haag.accenturetest.R
import com.haag.accenturetest.model.Book
import com.haag.accenturetest.model.Response
import com.haag.accenturetest.util.lineDivider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_category.*

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private val vm: CategoryViewModel by viewModels()
    private val args: CategoryFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = args.category.categories
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getCategory(args.category.type).observe(viewLifecycleOwner, Observer {
            categoryAdapter(it)
        })
    }

    private fun categoryAdapter(list: Response) {
        categoryRV.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = CategoryAdapter(list)
        }.lineDivider()

    }
}