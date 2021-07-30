package com.android.compose.swiggyclone

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp
class SwiggyCloneApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    fun getFoodImage(): Int {
        val images = resources.obtainTypedArray(R.array.food_images_array)
        val rand = Random()
        val rndInt = rand.nextInt(images.length())
        return images.getResourceId(rndInt, 0)
    }

    fun getRandomImage(): Int {
        val images = resources.obtainTypedArray(R.array.all_images_array)
        val rand = Random()
        val rndInt = rand.nextInt(images.length())
        return images.getResourceId(rndInt, 0)
    }

}