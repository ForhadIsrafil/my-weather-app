package com.example.myweather;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountriesDao {
    @Insert
    void insertCountryName(Countries countries); // to get list ids can use 'long []'

    @Update
    void updateCountryName(Countries countries);

    @Delete
    void deleteCountryName(Countries countries);

    @Query("select * from Countries order by name")
    LiveData<List<Countries>> getAllcountries();

}
