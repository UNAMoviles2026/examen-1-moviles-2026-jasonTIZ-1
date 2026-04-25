package com.moviles.examenmoviles.model

data class Space(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val description: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val availability: Boolean
)

