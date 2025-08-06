package com.ev.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ev.myapplication.model.respose.Category
import com.ev.myapplication.repository.Repository
import com.ev.myapplication.repository.RepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class ViewModelCategories(val repository: Repository): ViewModel() {



    var _categoriList: MutableLiveData<List<String>> = MutableLiveData(listOf<String>())
    var categoriList: LiveData<List<String>> = _categoriList

    var _categoryInfo: MutableLiveData<Category> = MutableLiveData()
    var categoryInfo: LiveData<Category> = _categoryInfo

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getCategories()
            _categoriList.postValue(list)
        }
    }

    fun getCategoryDetails(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getCategoriesDetails(category)
            _categoryInfo.postValue(result)
        }
    }

}