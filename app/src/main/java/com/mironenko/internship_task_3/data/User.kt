package com.mironenko.internship_task_3.data

data class User(
    val id: String,
    val name: String,
    val gender: String?,
    val dateOfBirth: String?,
    val nationality: String?,
    val email: String?,
    val phone: String?,
    val cell: String?,
    val country: String?,
    val state: String?,
    val city: String?,
    val postcode: String?,
    val registeredDate: String?,
    val registeredAge: String?,
    val pictureLarge: String?,
    val pictureThumbnail: String?
)