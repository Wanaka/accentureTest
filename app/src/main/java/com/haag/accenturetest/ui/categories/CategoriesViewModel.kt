package com.haag.accenturetest.ui.categories

import android.util.Log.d
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.haag.accenturetest.model.Categories
import com.haag.accenturetest.repository.CategoriesRepository
import kotlinx.coroutines.*

class CategoriesViewModel @ViewModelInject constructor(private val categoriesRepo: CategoriesRepository) :
    ViewModel() {

    var TAG = "CategoriesViewModel"

    fun getCategoriesDB(): LiveData<List<Categories>> {
        var categories = MutableLiveData<List<Categories>>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val deferred =
                    async { categoriesRepo.getCategories().sortedBy { it.categories } }

                withContext(Dispatchers.Main) {
                    categories.value = deferred.await()

                    if (categories.value.isNullOrEmpty()) {
                        val def =
                            async { categoriesRepo.getCategoriesApi().sortedBy { it.categories } }
                        categories.value = def.await()
                        updateRoomDB(def.await())
                    }
                }
            } catch (e: Exception) {
                d(TAG, "Exception: ${e.message}")
            }
        }

        return categories
    }

    private fun updateRoomDB(list: List<Categories>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Default) {
                    list
                }.forEach {
                    launch { categoriesRepo.saveCategories(it) }
                }
            } catch (e: Exception) {
                d(TAG, "Exception: ${e.message}")
            }
        }
    }

    fun navigateTo(view: View, category: Categories) {
        val action =
            CategoriesFragmentDirections.actionCategoriesFragmentToCategoryFragment(category)
        view.findNavController().navigate(action)
    }
}