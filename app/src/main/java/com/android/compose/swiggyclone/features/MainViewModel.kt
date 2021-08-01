package com.android.compose.swiggyclone.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.compose.swiggyclone.data.models.Photo
import com.android.compose.swiggyclone.data.repository.PhotosRepository
import com.android.compose.swiggyclone.di.NetworkException
import com.android.compose.swiggyclone.utils.Constants.PER_PAGE_COUNT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val photosRepository: PhotosRepository) :
    ViewModel() {

    val imagesData: LiveData<Resource<List<Photo>>>
        get() = _imagesData

    private val _imagesData = MutableLiveData<Resource<List<Photo>>>()

    init {
        getImages(1, PER_PAGE_COUNT)

    }

    fun getImages(pageNo: Int, perPage: Int, query: String = "food") {
        _imagesData.value = Resource.loading()
        viewModelScope.launch {
            val result = photosRepository.getPhotos(pageNo, perPage, query)
            try {
                if (result.data.isNullOrEmpty()) {
                    _imagesData.value = Resource.empty("")
                } else {
                    _imagesData.value = Resource.success(result.data)
                }
            } catch (e: Exception) {
                if (e is NetworkException) {
                    _imagesData.value = Resource.offlineError("")
                } else {
                    _imagesData.value = Resource.error("")
                }
            }
        }
    }


    fun getRandomTinyImage(): String? {
        return _imagesData.value?.data?.map { it.source.tiny }?.random()
    }

    fun getRandomMediumImage(): String? {
        return _imagesData.value?.data?.map { it.source.medium }?.random()
    }
}