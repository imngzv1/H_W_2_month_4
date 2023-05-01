package com.example.taskapp.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.databinding.ItemOnBoardingBinding
import com.example.taskapp.model.OnBoard
import com.example.taskapp.utils.loadImage

class OnBoardingAdapter(private val  onClick: (OnBoard) -> Unit) :
    androidx.recyclerview.widget.RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            title = "Title 1",
            desc = "Desc 1",
            image = "https://vervoe.com/wp-content/uploads/2022/01/job-task-analysis.jpg"
        ),
        OnBoard(
            title = "Title 2",
            desc = "Desc 2",
            image = "https://vervoe.com/wp-content/uploads/2022/01/job-task-analysis.jpg"
        ),
        OnBoard(
            title = "Title 3",
            desc = "Desc 3",
            image = "https://vervoe.com/wp-content/uploads/2022/01/job-task-analysis.jpg"
        ),

        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnOnBoarding.setOnClickListener {
                onClick(onBoard)
            }
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.title
            binding.ivOnBoard.loadImage(onBoard.image)
        }
    }
    }