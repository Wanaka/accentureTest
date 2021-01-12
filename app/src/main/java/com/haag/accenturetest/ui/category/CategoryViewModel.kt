package com.haag.accenturetest.ui.category

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haag.accenturetest.model.Response
import com.haag.accenturetest.repository.CategoryRepository
import com.haag.accenturetest.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CategoryViewModel @ViewModelInject constructor(private val categoryRepo: CategoryRepository) :
    ViewModel() {

    var TAG = "CategoryViewModel"

    fun getCategory(category: Int): LiveData<Response> {
        var list = MutableLiveData<Response>()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val deferred = when (category) {
                    Constants.TYPE_BOOK -> async { categoryRepo.getBooks() }
                    Constants.TYPE_HOUSE -> async { categoryRepo.getHouses() }
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