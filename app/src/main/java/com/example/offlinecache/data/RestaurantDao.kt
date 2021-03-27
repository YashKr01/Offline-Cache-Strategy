package com.example.offlinecache.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurant: List<Restaurant>)

    @Query("DELETE FROM `table`")
    suspend fun deleteAllRestaurants()

    @Query("SELECT * FROM `table`")
    fun getAllRestaurants(): Flow<List<Restaurant>>

}