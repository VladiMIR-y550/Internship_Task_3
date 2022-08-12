package com.mironenko.internship_task_3.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mironenko.internship_task_3.R
import com.mironenko.internship_task_3.UserApp
import com.mironenko.internship_task_3.base.BaseFragment
import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.databinding.FragmentUserListBinding
import com.mironenko.internship_task_3.ui.details.UserDetailsFragment
import com.mironenko.internship_task_3.util.factory.UserListViewModelFactory

class UserListFragment : BaseFragment<FragmentUserListBinding>() {
    private val viewModel: UserListViewModel by viewModels {
        UserListViewModelFactory(
            application = requireContext().applicationContext as UserApp
        )
    }

    override val viewBindingProvider: (LayoutInflater, ViewGroup?) -> FragmentUserListBinding =
        { inflater, container ->
            FragmentUserListBinding.inflate(inflater, container, false)
        }

    private val userAdapter by lazy {
        UserListAdapter({
            navigateToDetails(it)
        }, {
            viewModel.loadUsers()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.loadUsers()
        viewModel.state.observe(viewLifecycleOwner, ::renderState)
    }

    private fun renderState(newState: UserListState) {
        userAdapter.submitList(newState.usersList)
    }

    private fun initViews() {
        with(binding) {
            userRecycler.adapter = userAdapter
            userRecycler.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun navigateToDetails(user: User) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container_fragments, UserDetailsFragment.newInstance(userId = user.id))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance() = UserListFragment()
    }
}