package com.moviles.examenmoviles.model

data class Reservation(
    val id: String,
    val spaceId: Int,
    val spaceName: String,
    val location: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val totalPrice: Double,
    val status: String
)

