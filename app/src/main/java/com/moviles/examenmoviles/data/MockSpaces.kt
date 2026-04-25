package com.moviles.examenmoviles.data

import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.model.Space

object MockSpaces {
    val spaces = listOf(
        Space(
            id = 1,
            name = "Andes Hub",
            imageRes = R.drawable.space_andes_hub,
            description = "Open coworking area with fast Wi-Fi, ergonomic chairs, and shared meeting booths.",
            location = "Quito, Business District",
            capacity = 35,
            pricePerHour = 4.5,
            availability = true
        ),
        Space(
            id = 2,
            name = "Pacific Labs",
            imageRes = R.drawable.space_pacific_labs,
            description = "Quiet focused space designed for developers and product teams.",
            location = "Guayaquil, Puerto Santa Ana",
            capacity = 20,
            pricePerHour = 6.0,
            availability = false
        ),
        Space(
            id = 3,
            name = "Sierra Creative Loft",
            imageRes = R.drawable.space_sierra_loft,
            description = "Creative loft with podcast room, whiteboards, and collaborative desks.",
            location = "Cuenca, Historic Center",
            capacity = 28,
            pricePerHour = 5.25,
            availability = true
        )
    )
}



