package com.mironenko.internship_task_3.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.databinding.LayoutListItemBinding

class UserListAdapter(
    private val onItemClicked: (User) -> Unit
) : ListAdapter<User, UserListAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(currentList[position], onItemClicked)
    }

    inner class UserViewHolder(
        private val binding: LayoutListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, onItemClicked: (User) -> Unit) {
            with(binding) {
                tvListItemName.text = user.name
                root.setOnClickListener {
                    onItemClicked(user)
                }
            }
        }
    }

    class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}