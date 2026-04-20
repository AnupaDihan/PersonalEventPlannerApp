package com.example.personaleventplannerapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.example.personaleventplannerapp.data.Event
import com.example.personaleventplannerapp.database.EventDatabase

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val eventDao = EventDatabase.getInstance(application).eventDao()

    val allEvents: StateFlow<List<Event>> = eventDao.getAllEvents()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertEvent(event: Event) = viewModelScope.launch {
        eventDao.insertEvent(event)
    }

    fun updateEvent(event: Event) = viewModelScope.launch {
        eventDao.updateEvent(event)
    }

    fun deleteEvent(event: Event) = viewModelScope.launch {
        eventDao.deleteEvent(event)
    }

    suspend fun getEventById(id: Long): Event? {
        return eventDao.getEventById(id)
    }
}