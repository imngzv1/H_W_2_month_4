package com.example.h_w_1_4month.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.databinding.ItemTaskBinding
import com.example.taskapp.model.Task


class TaskAdapter(param: Any, param1: Any?) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val data= arrayListOf<Task>()
    fun addTask(task: Task){
        data.add(0,task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    class  TaskViewHolder(private  val binding: ItemTaskBinding):ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text=task.title
            binding.tvDesc.text=task.desc
        }
    }

}