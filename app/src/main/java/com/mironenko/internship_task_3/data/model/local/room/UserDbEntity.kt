package com.mironenko.internship_task_3.data.model.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserDbEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo
    val gender: String?,
    @ColumnInfo
    val nameTitle: String?,
    @ColumnInfo
    val nameFirst: String?,
    @ColumnInfo
    val nameLast: String?,
    @ColumnInfo
    val locationStreetNumber: Int?,
    @ColumnInfo
    val locationStreetName: String?,
    @ColumnInfo
    val locationCity: String?,
    @ColumnInfo
    val locationState: String?,
    @ColumnInfo
    val locationCountry: String?,
    @ColumnInfo
    val locationPostcode: String?,
    @ColumnInfo
    val locationCoordinatesLatitude: String?,
    @ColumnInfo
    val locationCoordinatesLongitude: String?,
    @ColumnInfo
    val locationTimezoneOffset: String?,
    @ColumnInfo
    val locationTimezoneDescription: String?,
    @ColumnInfo
    val email: String?,
    @ColumnInfo
    val loginUuid: String?,
    @ColumnInfo
    val loginUserName: String?,
    @ColumnInfo
    val loginPassword: String?,
    @ColumnInfo
    val loginSalt: String?,
    @ColumnInfo
    val loginMd5: String?,
    @ColumnInfo
    val loginSha1: String?,
    @ColumnInfo
    val loginSha256: String?,
    @ColumnInfo
    val dobDate: String?,
    @ColumnInfo
    val dobAge: Int?,
    @ColumnInfo
    val registeredDate: String?,
    @ColumnInfo
    val registeredAge: Int?,
    @ColumnInfo
    val phone: String?,
    @ColumnInfo
    val cell: String?,
    @ColumnInfo
    val idName: String?,
    @ColumnInfo
    val idValue: String?,
    @ColumnInfo
    val pictureLarge: String?,
    @ColumnInfo
    val pictureMedium: String?,
    @ColumnInfo
    val pictureThumbnail: String?,
    @ColumnInfo
    val nationality: String?,
) {
    companion object {
        const val TABLE_NAME = "users_table"
    }
}