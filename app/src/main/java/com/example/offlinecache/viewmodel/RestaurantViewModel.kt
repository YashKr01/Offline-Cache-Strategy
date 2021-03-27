package com.example.offlinecache.viewmodel

import androidx.lifecycle.*
import com.example.offlinecache.api.RestaurantApi
import com.example.offlinecache.data.Repository
import com.example.offlinecache.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()

}