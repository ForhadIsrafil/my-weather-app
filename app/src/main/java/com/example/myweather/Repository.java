//package com.example.myweather;
//
//import android.app.Application;
//import android.os.AsyncTask;
//
//import androidx.lifecycle.LiveData;
//
//import java.util.List;
//
//public class Repository {
//    public CountriesDao countriesDao;
//    LiveData<List<Countries>> getAllcountriesName;
//
//    Repository(Application application) {
//        CountryDatabase db = CountryDatabase.getDatabase(application);
//        countriesDao = db.countriesDao();
//        LiveData<List<Countries>> allCountries = countriesDao.getAllcountries();
//    }
//
//    public void insertCountryName(Countries countries){
//        new InsertTask(countriesDao).execute(countries);
//    }
//
//    public static class InsertTask extends AsyncTask<Countries,Void,Void>{
//        private CountriesDao countriesDao;
//
//        public InsertTask(CountriesDao countriesDao) {
//            this.countriesDao = countriesDao;
//        }
//
//        @Override
//        protected Void doInBackground(Countries... countries) {
//            countriesDao.insertCountryName(countries[0]);
//            return null;
//        }
//    }
//
//}
//
