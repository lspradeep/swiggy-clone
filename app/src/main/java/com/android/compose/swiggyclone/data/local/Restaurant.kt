package com.android.compose.swiggyclone.data.local

data class Restaurant(
    val name: String,
    val cuisines: String,
    val deliveryTime: String,
    val place: String,
    val kilometersAway: String,
    val offerPercentage: Int,
    val costForTwo: Int,
    val rating: Float
)

val restaurantData = listOf(
    Restaurant(
        name = "Muniyandi Vilas",
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
        cuisines = "South Indian, Pure veg",
        deliveryTime = "13 mins",
        place = "Tiruvallur",
        kilometersAway = "2.2 kms",
        offerPercentage = 20,
        costForTwo = 200,
        rating = 4f
    ),
)