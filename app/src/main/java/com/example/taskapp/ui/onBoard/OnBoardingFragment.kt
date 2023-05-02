package com.example.taskapp.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.data.remote.Pref
import com.example.taskapp.databinding.FragmentOnBoardingBinding
import com.example.taskapp.model.OnBoard
import com.example.taskapp.ui.onBoard.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var  binding: FragmentOnBoardingBinding
    private lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOnBoardingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())
        val adapter=OnBoardingAdapter(this::onClick)
        binding.viewPagerr.adapter=adapter
        binding.indicator.setViewPager(binding.viewPagerr)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }
    private fun onClick(onBoard:OnBoard){
        findNavController().navigateUp()
        pref.saveUserSeen()
    }
}