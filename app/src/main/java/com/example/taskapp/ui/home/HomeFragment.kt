package com.example.h_w_1_4month.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.h_w_1_4month.ui.home.adapter.TaskAdapter
import com.example.h_w_1_4month.ui.task.TaskFragment
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.model.Task

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter= TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root ?: binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setFragmentResultListener(TaskFragment.TASK_REQUEST) { _, bundle ->
            val result = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.addTask(result)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }
}