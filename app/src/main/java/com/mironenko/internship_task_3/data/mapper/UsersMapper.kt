package com.mironenko.internship_task_3.data.mapper

import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.Id
import com.mironenko.internship_task_3.data.model.remote.UserResponse
import com.mironenko.internship_task_3.util.DateFormatter
import java.util.*

class UsersMapper : EntityMapper<UserResponse, UserDbEntity, User> {
    override fun dbEntityToUser(dbEntity: UserDbEntity): User {
        return User(
            id = dbEntity.id,
            name = dbEntity.nameFirst + dbEntity.nameLast,
            gender = dbEntity.gender,
            dateOfBirth = dbEntity.dobDate,
            nationality = dbEntity.nationality,
            email = dbEntity.email,
            phone = dbEntity.phone,
            cell = dbEntity.cell,
            country = dbEntity.locationCountry,
            state = dbEntity.locationState,
            city = dbEntity.locationCity,
            postcode = dbEntity.locationPostcode,
            registeredDate = dbEntity.registeredDate,
            registeredAge = dbEntity.registeredDate,
            pictureLarge = dbEntity.pictureLarge,
            pictureThumbnail = dbEntity.pictureThumbnail
        )
    }

    override fun responseEntityToDbEntity(responseEntity: UserResponse): UserDbEntity {
        return UserDbEntity(
            id = concatId(responseEntity.id),
            gender = responseEntity.gender,
            nameTitle = responseEntity.name.title,
            nameFirst = responseEntity.name.first,
            nameLast = responseEntity.name.last,
            locationStreetNumber = responseEntity.location.street.number,
            locationStreetName = responseEntity.location.street.name,
            locationCity = responseEntity.location.city,
            locationState = responseEntity.location.state,
            locationCountry = responseEntity.location.country,
            locationPostcode = responseEntity.location.postcode,
            locationCoordinatesLatitude = responseEntity.location.coordinates.latitude,
            locationCoordinatesLongitude = responseEntity.location.coordinates.longitude,
            locationTimezoneOffset = responseEntity.location.timezone.offset,
            locationTimezoneDescription = responseEntity.location.timezone.description,
            email = responseEntity.email,
            loginUuid = responseEntity.login.uuid,
            loginUserName = responseEntity.login.username,
            loginPassword = responseEntity.login.password,
            loginSalt = responseEntity.login.salt,
            loginMd5 = responseEntity.login.md5,
            loginSha1 = responseEntity.login.sha1,
            loginSha256 = responseEntity.login.sha256,
            dobDate = formatDate(responseEntity.dob.date),
            dobAge = responseEntity.dob.age,
            registeredDate = formatDate(responseEntity.registered.date),
            registeredAge = responseEntity.registered.age,
            phone = responseEntity.phone,
            cell = responseEntity.cell,
            idName = responseEntity.id.name,
            idValue = responseEntity.id.value,
            pictureLarge = responseEntity.picture.large,
            pictureMedium = responseEntity.picture.medium,
            pictureThumbnail = responseEntity.picture.thumbnail,
            nationality = responseEntity.nut
        )
    }

    override fun fromDbEntityList(initial: List<UserDbEntity>): List<User> {
        return initial.map { dbEntityToUser(it) }
    }

    override fun fromResponseEntityList(initial: List<UserResponse>): List<UserDbEntity> {
        return initial.map { responseEntityToDbEntity(it) }
    }

    private fun concatId(id: Id): String = "${id.name} ${id.value}"

    private fun formatDate(date: String?): String {
        val dateFromString = date?.let { DateFormatter.inputFormat.parse(it) } as Date
        return DateFormatter.outputFormat.format(dateFromString)
    }
}