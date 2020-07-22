package com.example.myweather;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Countries.class}, version = 1)
public abstract class CountryDatabase extends RoomDatabase {
    public CountriesDao countriesDao;
    private static volatile CountryDatabase INSTANCE;

    static CountryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CountryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CountryDatabase.class, "country_database")
                            .fallbackToDestructiveMigration() // if any changes in database that will be not effect of new migration on DB
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract CountriesDao countriesDao();
}