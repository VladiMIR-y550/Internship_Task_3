package com.mironenko.internship_task_3.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.mironenko.internship_task_3.R
import com.mironenko.internship_task_3.base.BaseFragment
import com.mironenko.internship_task_3.databinding.FragmentUserDetailsBinding
import com.mironenko.internship_task_3.util.ARG_USER_ID
import com.mironenko.internship_task_3.util.factory

class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding>() {
    private val viewModel: UserDetailsViewModel by viewModels { factory(itemId = itemId) }

    override val viewBindingProvider: (LayoutInflater, ViewGroup?) -> FragmentUserDetailsBinding =
        { inflater, container ->
            FragmentUserDetailsBinding.inflate(inflater, container, false)
        }

    private val itemId by lazy {
        arguments?.getString(ARG_USER_ID, "") ?: ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        viewModel.state.observe(viewLifecycleOwner, ::renderState)
    }

    private fun renderState(newState: UserDetailState) {
        newState.user?.also { user ->
            with(binding) {
                Glide.with(binding.ivAvatar.context)
                    .load(user.pictureLarge)
                    .placeholder(R.drawable.ic_avatar)
                    .error(R.drawable.ic_error)
                    .into(binding.ivAvatar)

                tvNameField.text = user.name
                tvGenderField.text = user.gender
                tvDobField.text = user.dateOfBirth
                tvNationalityField.text = user.nationality
                tvEmailField.text = user.email
                tvPhoneField.text = user.phone
                tvCellField.text = user.cell
                tvCityField.text = user.city
                tvStateField.text = user.state
                tvCountryField.text = user.country
                tvPostcodeField.text = user.postcode
                tvRegisteredDateField.text = user.registeredDate
                tvRegisteredAgeField.text = user.registeredAge
            }
        }
    }

    companion object {
        fun newInstance(userId: String) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_USER_ID, userId)
            }
        }
    }
}