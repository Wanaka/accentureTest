package com.haag.accenturetest.ui.categories

import android.util.Log.d
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.haag.accenturetest.model.Categories
import com.haag.accenturetest.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoriesViewModel @ViewModelInject constructor(private val categoriesRepo: CategoriesRepository) :
    ViewModel() {

    var TAG = "CategoriesViewModel"

    fun getCategoriesApi(): LiveData<List<Categories>> {
        var categories = MutableLiveData<List<Categories>>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val deferred =
                    async { categoriesRepo.getCategoriesApi().sortedBy { it.categories } }

                withContext(Dispatchers.Main) {
                    categories.value = deferred.await()
                }

            } catch (e: Exception) {
                d(TAG, "Exception: ${e.message}")
            }
        }

        return categories
    }

    fun navigateTo(view: View, category: Categories) {
        val action =
            CategoriesFragmentDirections.actionCategoriesFragmentToCategoryFragment(category)
        view.findNavController().navigate(action)
    }
}