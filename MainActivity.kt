package com.carpal.myapplication

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.carpal.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedImageUri: Uri? = null

    // Register file picker outside onCreate
    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedImageUri = it
                ImageUtils.loadImage(this, it, binding.imageView)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load default image
        Glide.with(this)
            .load("https://picsum.photos/200")
            .into(binding.imageView)

        // Pick image from gallery when button is clicked
        binding.pickImageButton.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }
    }
}
