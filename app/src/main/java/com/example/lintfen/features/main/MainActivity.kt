package com.example.lintfen.features.main

import android.app.Activity
import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.lintfen.databinding.ActivityMainBinding
import com.example.lintfen.features.base.BaseActivity
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.UUID


class MainActivity : BaseActivity() {

//    MARK: Properties
    private lateinit var binding: ActivityMainBinding

    //    MARK: Main
    override fun getLayout(): ConstraintLayout {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        val mWebPath = "https://nguyenvanhuy0409.com/app/batterycharger/background/bg_19.png"

        Glide.with(this)
            .asBitmap()
            .load(mWebPath)
            .into(object : CustomTarget<Bitmap?>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?
                ) {
//                    binding.imageView.setImageBitmap(resource)
                    saveImage(binding.imageView, this@MainActivity)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })


    }

    override fun initData() {

    }

    override fun initEventListener() {

    }

    private fun saveImage(itemImage: View, activity: Activity) {
        val fileName: String
        val imageFromView = getBitmapFromView(itemImage)

        ByteArrayOutputStream().apply {
            imageFromView.compress(Bitmap.CompressFormat.PNG, 100, this)
            fileName = UUID.nameUUIDFromBytes(this.toByteArray()).toString().replace("-", "")
        }

        val imageFile =  File("${activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)}/ChatOut/$fileName.png/")

        if (!imageFile.exists()) {

            val contentResolver = ContentValues().apply {
                put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis())
                put(MediaStore.Images.Media.MIME_TYPE, "image/png")
                put(MediaStore.Images.Media.DATA, imageFile.absolutePath)
            }

            activity.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentResolver).apply {
                imageFromView.compress(Bitmap.CompressFormat.JPEG, 100, activity.contentResolver.openOutputStream(this!!))
            }


            Toast.makeText(activity, "saved", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(activity, "Already saved", Toast.LENGTH_SHORT).show()
    }



    private fun getBitmapFromView(view: View): Bitmap {
        return Bitmap.createBitmap(view.width, view.height,Bitmap.Config.ARGB_8888).apply {
            Canvas(this).apply {
                view.draw(this)
            }
        }
    }
}








