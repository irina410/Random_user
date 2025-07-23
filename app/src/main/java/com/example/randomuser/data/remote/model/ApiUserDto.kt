package com.example.randomuser.data.remote.model

import com.example.randomuser.domain.User

data class ApiUserDto(
    val login: LoginDto,
    val name: NameDto,
    val phone: String,
    val email: String,
    val dob: DobDto,
    val location: LocationDto,
    val picture: PictureDto
)

fun ApiUserDto.toDomain(): User {
    return User(
        username = login.username,
        firstName = name.first,
        lastName = name.last,
        phone = phone,
        email = email,
        dateOfBirth = dob.date,
        country = location.country,
        city = location.city,
        state = location.state,
        street = "${location.street.name} ${location.street.number}",
        photoUrl = picture.large
    )
}
