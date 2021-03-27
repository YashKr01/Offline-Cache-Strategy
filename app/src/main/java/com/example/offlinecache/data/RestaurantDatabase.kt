package com.example.offlinecache.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class], exportSchema = false, version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao




}