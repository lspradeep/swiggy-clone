package com.android.compose.swiggyclone

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class SwiggyCloneApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object{
//        fun getRandomImage() {
//            Log.d("da", "getRandomImage")
//            val drawableClass = R.drawable::class.java
//            File("src/main/res/drawable").walk()
//                .forEach {
//                    Log.d("da", it.name)
//                }
//            val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
//            val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/res/drawable")
//            Files.walk(resourcesPath)
//                .filter { item -> Files.isRegularFile(item) }
//                .filter { item -> item.toString().endsWith(".png") }
//                .forEach { item -> println("filename: $item") }
//
////        val field = drawableClass.getDeclaredField(fileName)
////        field.getInt(field)
////        return field.getInt(field)
//        }
    }
}