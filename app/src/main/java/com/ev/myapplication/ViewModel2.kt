package com.ev.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel2: ViewModel() {

    init {
        viewModelScope.launch {

        }
    }
}