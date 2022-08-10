package com.mironenko.internship_task_3.data.mapper

import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity

class UserMapper : EntityMapper<UserDbEntity, User> {
    override fun mapFromEntity(entity: UserDbEntity): User {
        return User(
            id = entity.id,
            name = entity.nameFirst + entity.nameLast,
            gender = entity.gender,
            dateOfBirth = entity.dobDate,
            nationality = entity.nationality,
            email = entity.email,
            phone = entity.phone,
            cell = entity.cell,
            country = entity.locationCountry,
            state = entity.locationState,
            city = entity.locationCity,
            postcode = entity.locationPostcode,
            registeredDate = entity.registeredDate,
            registeredAge = entity.registeredDate,
            pictureLarge = entity.pictureLarge,
            pictureThumbnail = entity.pictureThumbnail
        )
    }

    override fun fromEntityList(initial: List<UserDbEntity>): List<User> {
        return initial.map { mapFromEntity(it) }
    }
}