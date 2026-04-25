package com.moviles.examenmoviles.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.moviles.examenmoviles.data.MockSpaces
import com.moviles.examenmoviles.model.Reservation
import com.moviles.examenmoviles.model.Space
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoworkingViewModel : ViewModel() {
    private val spacesData: List<Space> = MockSpaces.spaces

    private val _reservations = MutableStateFlow<List<Reservation>>(emptyList())
    val reservations: StateFlow<List<Reservation>> = _reservations.asStateFlow()

    fun spaces(): List<Space> = spacesData

    fun findSpaceById(spaceId: Int?): Space? = spacesData.firstOrNull { it.id == spaceId }

    fun isReserved(spaceId: Int): Boolean = _reservations.value.any { it.spaceId == spaceId }

    fun reserveSpace(space: Space) {
        if (!space.availability || isReserved(space.id)) {
            return
        }

        val reservation = Reservation(
            id = "rsv-${space.id}",
            spaceId = space.id,
            spaceName = space.name,
            location = space.location,
            date = "2026-04-25",
            startTime = "09:00",
            endTime = "11:00",
            totalPrice = space.pricePerHour * 2,
            status = "confirmed"
        )

        _reservations.value = listOf(reservation) + _reservations.value
    }
}

