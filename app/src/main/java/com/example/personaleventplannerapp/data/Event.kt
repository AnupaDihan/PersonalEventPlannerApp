package com.example.personaleventplannerapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val category: String,  // Work, Social, Travel
    val location: String,
    val dateTime: Date
)