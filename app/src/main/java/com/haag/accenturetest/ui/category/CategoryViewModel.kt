package com.haag.accenturetest.ui.category

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haag.accenturetest.model.Book
import com.haag.accenturetest.model.Categories
import com.haag.accenturetest.model.Response
import com.haag.accenturetest.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CategoryViewModel @ViewModelInject constructor(private val categoryRepo: CategoryRepository) :
    ViewModel() {
    var TAG = "CategoryViewModel"

    companion object {
        const val TYPE_BOOK = 0
        const val TYPE_HOUSE = 1
        const val TYPE_CHARACTER = 2
    }

    fun getCategory(category: Int): LiveData<Response> {
        var list = MutableLiveData<Response>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val deferred = when (category) {
                    TYPE_BOOK -> async { categoryRepo.getBooks() }
                    TYPE_HOUSE -> async { categoryRepo.getHouses() }
                    else -> async { categoryRepo.getCharacters() }
                }

                withContext(Dispatchers.Main) {
                    list.value = Response(category, deferred.await())
                }

            } catch (e: Exception) {
                Log.d(TAG, "Exception: ${e.message}")
            }

        }

        return list
    }
}