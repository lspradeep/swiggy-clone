package com.android.compose.swiggyclone.features

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.NoFood
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.compose.swiggyclone.data.models.coupon.Coupon
import com.android.compose.swiggyclone.data.models.curation.Curation
import com.android.compose.swiggyclone.data.models.restaurant.Restaurant
import com.android.compose.swiggyclone.data.models.servicetype.ServiceType
import com.android.compose.swiggyclone.data.models.photo.Photo
import com.android.compose.swiggyclone.data.repository.PhotosRepository
import com.android.compose.swiggyclone.di.NetworkException
import com.android.compose.swiggyclone.features.nav.Routes
import com.android.compose.swiggyclone.ui.theme.couponColor1
import com.android.compose.swiggyclone.ui.theme.couponColor2
import com.android.compose.swiggyclone.ui.theme.couponColor3
import com.android.compose.swiggyclone.utils.Constants.PER_PAGE_COUNT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val photosRepository: PhotosRepository) :
    ViewModel() {

    //HomeScreen
    val imagesData: LiveData<Resource<List<Photo>>>
        get() = _imagesData

    private val _imagesData = MutableLiveData<Resource<List<Photo>>>()

    init {
        getImages(1, PER_PAGE_COUNT)
    }

    private fun getImages(pageNo: Int, perPage: Int, query: String = "food") {
        _imagesData.value = Resource.loading()
        viewModelScope.launch {
            val result = photosRepository.getPhotos(pageNo, perPage, query)
            try {
                if (result.data.isNullOrEmpty()) {
                    _imagesData.value = Resource.empty("")
                } else {
                    _imagesData.value = Resource.success(result.data)
                    constructFakeDataSet()

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

    private fun getRandomTinyImage(): String? {
        return _imagesData.value?.data?.map { it.source.tiny }?.random()
    }

    private fun getRandomMediumImage(): String? {
        return _imagesData.value?.data?.map { it.source.medium }?.random()
    }

    //serviceTypes
    val serviceTypes: LiveData<List<ServiceType>?>
        get() = _serviceTypes
    private val _serviceTypes = MutableLiveData<List<ServiceType>?>()

    val allRestaurants: LiveData<List<Restaurant>?>
        get() = _allRestaurants
    private val _allRestaurants = MutableLiveData<List<Restaurant>?>()

    val restaurantsYouLove: LiveData<List<Restaurant>?>
        get() = _restaurantsYouLove
    private val _restaurantsYouLove = MutableLiveData<List<Restaurant>?>()

    val inTheSpotlight: LiveData<List<Restaurant>?>
        get() = _inTheSpotlight
    private val _inTheSpotlight = MutableLiveData<List<Restaurant>?>()

    val trySomethingNew: LiveData<List<Restaurant>?>
        get() = _trySomethingNew
    private val _trySomethingNew = MutableLiveData<List<Restaurant>?>()

    val topOffers: LiveData<List<Restaurant>?>
        get() = _topOffers
    private val _topOffers = MutableLiveData<List<Restaurant>?>()

    val curations: LiveData<List<Curation>?>
        get() = _curations
    private val _curations = MutableLiveData<List<Curation>?>()

    val coupons: LiveData<List<Coupon>?>
        get() = _coupons
    private val _coupons = MutableLiveData<List<Coupon>?>()

    private fun constructFakeDataSet() {
        val serviceTypesData = listOf(
            ServiceType(
                "Restaurant",
                getRandomMediumImage(),
                "Enjoy Your favourite treats"
            ),
            ServiceType(
                "Health Hub",
                getRandomMediumImage(),
                "Enjoy Your favourite treats"
            ),
            ServiceType(
                "Care Corner",
                getRandomMediumImage(),
                "Enjoy Your favourite treats"
            ),
            ServiceType(
                "Health Hub",
                getRandomMediumImage(),
                "Enjoy Your favourite treats"
            ),
            ServiceType(
                "Care Corner",
                getRandomMediumImage(),
                "Enjoy Your favourite treats"
            )
        )

        val restaurantsData = listOf(
            Restaurant(
                name = "Muniyandi Vilas",
                image = getRandomTinyImage(),
                cuisines = "South Indian",
                deliveryTime = "20 mins",
                place = "Vengal",
                kilometersAway = "2 kms",
                offerPercentage = 20,
                costForTwo = 200,
                rating = 4f
            ),
            Restaurant(
                name = "KFC",
                image = getRandomTinyImage(),
                cuisines = "American",
                deliveryTime = "25 mins",
                place = "Tiruvallur",
                kilometersAway = "2.3 kms",
                offerPercentage = 10,
                costForTwo = 240,
                rating = 3f
            ),
            Restaurant(
                name = "Arya Hotel",
                image = getRandomTinyImage(),
                cuisines = "North Indian",
                deliveryTime = "13 mins",
                place = "Tiruvallur",
                kilometersAway = "1.3 kms",
                offerPercentage = 30,
                costForTwo = 240,
                rating = 3.8f
            ),
            Restaurant(
                name = "Golden Spoon Vilas",
                image = getRandomTinyImage(),
                cuisines = "South Indian, North Indian",
                deliveryTime = "20 mins",
                place = "Vengal",
                kilometersAway = "3 kms",
                offerPercentage = 30,
                costForTwo = 210,
                rating = 4.1f
            ),
            Restaurant(
                name = "Meat and Eat",
                image = getRandomTinyImage(),
                cuisines = "American",
                deliveryTime = "20 mins",
                place = "Vengal",
                kilometersAway = "2 kms",
                offerPercentage = 20,
                costForTwo = 200,
                rating = 4f
            ),
            Restaurant(
                name = "Perambur Srinivasa",
                image = getRandomTinyImage(),
                cuisines = "South Indian, Pure veg",
                deliveryTime = "13 mins",
                place = "Tiruvallur",
                kilometersAway = "2.2 kms",
                offerPercentage = 20,
                costForTwo = 200,
                rating = 4f
            ),
            Restaurant(
                name = "Muniyandi Vilas",
                image = getRandomTinyImage(),
                cuisines = "South Indian",
                deliveryTime = "20 mins",
                place = "Vengal",
                kilometersAway = "2 kms",
                offerPercentage = 20,
                costForTwo = 200,
                rating = 4f
            ),
            Restaurant(
                name = "Arya Hotel",
                image = getRandomTinyImage(),
                cuisines = "North Indian",
                deliveryTime = "13 mins",
                place = "Tiruvallur",
                kilometersAway = "1.3 kms",
                offerPercentage = 30,
                costForTwo = 240,
                rating = 3.8f
            ),
            Restaurant(
                name = "Golden Spoon Vilas",
                image = getRandomTinyImage(),
                cuisines = "South Indian, North Indian",
                deliveryTime = "20 mins",
                place = "Vengal",
                kilometersAway = "3 kms",
                offerPercentage = 30,
                costForTwo = 210,
                rating = 4.1f
            ),
            Restaurant(
                name = "Meat and Eat",
                image = getRandomTinyImage(),
                cuisines = "American",
                deliveryTime = "20 mins",
                place = "Vengal",
                kilometersAway = "2 kms",
                offerPercentage = 20,
                costForTwo = 200,
                rating = 4f
            ),
            Restaurant(
                name = "Perambur Srinivasa",
                image = getRandomTinyImage(),
                cuisines = "South Indian, Pure veg",
                deliveryTime = "13 mins",
                place = "Tiruvallur",
                kilometersAway = "2.2 kms",
                offerPercentage = 20,
                costForTwo = 200,
                rating = 4f
            ),
        )

        val curationsData = listOf(
            Curation("Burgers", getRandomTinyImage()),
            Curation("South Indian", getRandomTinyImage()),
            Curation("Pure Veg", getRandomTinyImage()),
            Curation("North Indian", getRandomTinyImage()),
            Curation("Biryani", getRandomTinyImage()),
            Curation("Chinese", getRandomTinyImage()),
            Curation("Cakes & Deserts", getRandomTinyImage()),
        )

        val couponsData = listOf(
            Coupon(
                icon = Icons.Default.Fastfood,
                tint = couponColor1,
                smallText = "-Try New-",
                largeText = "up to 60% off",
            ),
            Coupon(
                icon = Icons.Default.FoodBank,
                tint = couponColor2,
                smallText = "-Welcome back-",
                largeText = "Missed you",
            ),
            Coupon(
                icon = Icons.Default.NoFood,
                tint = couponColor3,
                smallText = "-Unlimited-",
                largeText = "Large discounts",
            ),
            Coupon(
                icon = Icons.Default.EmojiFoodBeverage,
                tint = couponColor1,
                smallText = "Try New",
                largeText = "up to 60% off",
            ),
            Coupon(
                icon = Icons.Default.NoFood,
                tint = couponColor2,
                smallText = "Try New",
                largeText = "up to 60% off",
            )
        )

        _serviceTypes.value = serviceTypesData
        _allRestaurants.value = restaurantsData
        _restaurantsYouLove.value = restaurantsData.shuffled()
        _inTheSpotlight.value = restaurantsData.shuffled()
        _trySomethingNew.value = restaurantsData.shuffled()
        _topOffers.value = restaurantsData.shuffled()
        _curations.value = curationsData
        _coupons.value = couponsData
    }


    //SearchScreen
    val recentSearches: LiveData<List<String>>
        get() = _recentSearches

    private val _recentSearches = MutableLiveData<List<String>>()

    fun showLessRecentSearches() {
        _recentSearches.value = listOf("Meat and Eat", "Zamani Biryani", "Smokey Chimney")
    }

    fun showMoreRecentSearches() {
        _recentSearches.value = listOf(
            "Meat and Eat",
            "Zamani Biryani",
            "Smokey Chimney",
            "Hotel Mithra",
            "Little Diner"
        )
    }

    //Cart Counter
    val selectedMenuItem: LiveData<Routes>
        get() = _selectedNavMenuItem

    private val _selectedNavMenuItem = MutableLiveData<Routes>(Routes.HOME)

    //testing purpose
    val incrementCartCount: LiveData<Int>
        get() = _incrementCartCount

    private val _incrementCartCount = MutableLiveData<Int>(0)

    fun incrementCartCounter() {
        _incrementCartCount.value = _incrementCartCount.value?.plus(1)
    }
    //end test

    fun selectedNavMenu(selectedMenu: Routes) {
        _selectedNavMenuItem.value = selectedMenu
    }
}