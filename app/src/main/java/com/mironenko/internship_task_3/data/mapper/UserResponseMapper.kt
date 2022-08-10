package com.mironenko.internship_task_3.data.mapper

import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.Id
import com.mironenko.internship_task_3.data.model.remote.UserResponse
import com.mironenko.internship_task_3.util.DateFormatter
import java.util.*

class UserResponseMapper : EntityMapper<UserResponse, UserDbEntity> {

    override fun mapFromEntity(entity: UserResponse): UserDbEntity {
        return UserDbEntity(
            id = concatId(entity.id),
            gender = entity.gender,
            nameTitle = entity.name.title,
            nameFirst = entity.name.first,
            nameLast = entity.name.last,
            locationStreetNumber = entity.location.street.number,
            locationStreetName = entity.location.street.name,
            locationCity = entity.location.city,
            locationState = entity.location.state,
            locationCountry = entity.location.country,
            locationPostcode = entity.location.postcode,
            locationCoordinatesLatitude = entity.location.coordinates.latitude,
            locationCoordinatesLongitude = entity.location.coordinates.longitude,
            locationTimezoneOffset = entity.location.timezone.offset,
            locationTimezoneDescription = entity.location.timezone.description,
            email = entity.email,
            loginUuid = entity.login.uuid,
            loginUserName = entity.login.username,
            loginPassword = entity.login.password,
            loginSalt = entity.login.salt,
            loginMd5 = entity.login.md5,
            loginSha1 = entity.login.sha1,
            loginSha256 = entity.login.sha256,
            dobDate = formatDate(entity.dob.date),
            dobAge = entity.dob.age,
            registeredDate = formatDate(entity.registered.date),
            registeredAge = entity.registered.age,
            phone = entity.phone,
            cell = entity.cell,
            idName = entity.id.name,
            idValue = entity.id.value,
            pictureLarge = entity.picture.large,
            pictureMedium = entity.picture.medium,
            pictureThumbnail = entity.picture.thumbnail,
            nationality = entity.nut
        )
    }

    override fun fromEntityList(initial: List<UserResponse>): List<UserDbEntity> {
        return initial.map { mapFromEntity(it) }
    }

    private fun concatId(id: Id): String = "${id.name} ${id.value}"

    private fun formatDate(date: String?): String {
        val dateFromString = date?.let { DateFormatter.inputFormat.parse(it) } as Date
        return DateFormatter.outputFormat.format(dateFromString)
    }
}