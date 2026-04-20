# This personal event planner

## Overview

The Personal Event Planner App is an Android application developed for SIT305 Task 4.1P.
It allows users to manage their daily events, appointments, and trips efficiently through a simple and user-friendly interface.

The app supports full event management with local data storage, ensuring all information is محفوظ even after closing the app or restarting the device.

## Features
### CRUD Operations
- Create new events with title, category, location, and date/time
- View all upcoming events sorted by date
- Update existing event details
- Delete events easily
### Data Persistence (Room Database)
- Uses Room Persistence Library
- Stores all event data locally
- Data remains محفوظ after app restart
### Navigation
- Implemented using Jetpack Navigation Component
- Uses Fragments instead of multiple activities
- Smooth navigation between:
    - Event List Screen
    - Add Event Screen
## Validation & Error Handling
- Prevents empty title or date input
- Prevents selecting past dates
- Displays feedback using:
    - Toast messages
    - Snackbars
## Technologies Used
- Java / Kotlin (depending on your project)
- Android Studio
- Room Database
- Jetpack Navigation Component
- Material UI Components

## How to Run the App
- Clone this repository
- Open in Android Studio
- Sync Gradle
- Run the app using Emulator or Physical Device

## Demo Video
A video demonstration of the application is available here: https://youtu.be/b4si4FEORzo  

## Submission Details
- Unit: SIT305 – Mobile Application Development
- Task: 4.1P – Personal Event Planner App
- Student: [Anupa Dihan Hansaja Batagoda Gamage]
- Student ID: [s225181192]
- University: Deakin University

