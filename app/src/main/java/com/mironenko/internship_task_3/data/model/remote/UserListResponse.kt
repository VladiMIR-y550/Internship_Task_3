package com.mironenko.internship_task_3.data.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @Expose
    @SerializedName("results") val results: List<UserResponse> = listOf(),
    @Expose
    @SerializedName("info") val seed: Info
)

data class UserResponse(
    @Expose
    @SerializedName("gender") val gender: String? = null,
    @Expose
    @SerializedName("name") val name: Name,
    @Expose
    @SerializedName("location") val location: Location,
    @Expose
    @SerializedName("email") val email: String? = null,
    @Expose
    @SerializedName("login") val login: Login,
    @Expose
    @SerializedName("dob") val dob: Dob,
    @Expose
    @SerializedName("registered") val registered: Registered,
    @Expose
    @SerializedName("phone") val phone: String? = null,
    @Expose
    @SerializedName("cell") val cell: String? = null,
    @Expose
    @SerializedName("id") val id: Id,
    @Expose
    @SerializedName("picture") val picture: Picture,
    @Expose
    @SerializedName("nat") val nut: String? = null
)

data class Name(
    @Expose
    @SerializedName("title") val title: String? = null,
    @Expose
    @SerializedName("first") val first: String? = null,
    @Expose
    @SerializedName("last") val last: String? = null
)

data class Location(
    @Expose
    @SerializedName("street") val street: Street,
    @Expose
    @SerializedName("city") val city: String? = null,
    @Expose
    @SerializedName("state") val state: String? = null,
    @Expose
    @SerializedName("country") val country: String? = null,
    @Expose
    @SerializedName("postcode") val postcode: String? = null,
    @Expose
    @SerializedName("coordinates") val coordinates: Coordinates,
    @Expose
    @SerializedName("timezone") val timezone: Timezone,
)

data class Street(
    @Expose
    @SerializedName("number") val number: Int? = null,
    @Expose
    @SerializedName("name") val name: String? = null
)

data class Coordinates(
    @Expose
    @SerializedName("latitude") val latitude: String? = null,
    @Expose
    @SerializedName("longitude") val longitude: String? = null
)

data class Timezone(
    @Expose
    @SerializedName("offset") val offset: String? = null,
    @Expose
    @SerializedName("description") val description: String? = null
)

data class Login(
    @Expose
    @SerializedName("uuid") val uuid: String? = null,
    @Expose
    @SerializedName("username") val username: String? = null,
    @Expose
    @SerializedName("password") val password: String? = null,
    @Expose
    @SerializedName("salt") val salt: String? = null,
    @Expose
    @SerializedName("md5") val md5: String? = null,
    @Expose
    @SerializedName("sha1") val sha1: String? = null,
    @Expose
    @SerializedName("sha256") val sha256: String? = null
)

data class Dob(
    @Expose
    @SerializedName("date") val date: String? = null,
    @Expose
    @SerializedName("age") val age: Int? = null
)

data class Registered(
    @Expose
    @SerializedName("date") val date: String? = null,
    @Expose
    @SerializedName("age") val age: Int? = null
)

data class Id(
    @Expose
    @SerializedName("name") val name: String,
    @Expose
    @SerializedName("value") val value: String
)

data class Picture(
    @Expose
    @SerializedName("large") val large: String? = null,
    @Expose
    @SerializedName("medium") val medium: String? = null,
    @Expose
    @SerializedName("thumbnail") val thumbnail: String? = null,
)

data class Info(
    @Expose
    @SerializedName("results") val result: Int? = null,
    @Expose
    @SerializedName("page") val page: Int? = null,
    @Expose
    @SerializedName("version") val version: String? = null
)