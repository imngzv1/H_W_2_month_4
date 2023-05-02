package com.example.taskapp.ui.profile

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.example.taskapp.R
import com.example.taskapp.data.remote.Pref
import com.example.taskapp.databinding.FragmentProfileBinding
import java.util.prefs.Preferences

class ProfileFragment : Fragment() {

    lateinit var preferences: Pref

    private lateinit var binding: FragmentProfileBinding


    private val getContent: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()) { imageUri: Uri? ->

            Glide.with(this)
                .load(imageUri.toString())
                .into(binding.picture)
            preferences.saveImage(imageUri.toString())
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.picture.setOnClickListener {
            getContent.launch("image/*")
        }
        preferences = Pref(requireContext())
        saveChanges()
        checkChanges()
        return binding.root
    }

    private fun saveChanges() {
        binding.edTxt.addTextChangedListener {
            preferences.saveName(binding.edTxt.text.toString())
        }
    }

    private fun checkChanges() {
        if (preferences.getName() != "") {
            binding.edTxt.setText(preferences.getName())
        }
        if (preferences.getImage() != "") {
            Glide.with(this).load(preferences.getImage()).into(binding.picture)
        }
    }

}
