package com.example.sonet.recyclerviewdemo;

import java.util.ArrayList;

/**
 * Created by Sonet on 7/30/2016.
 */
public class DataProvider {

    String countryName;
    String countryCapital;
    int imgId;
    ArrayList<DataProvider> providers;

    public DataProvider(String countryCapital, String countryName, int imgId) {
        this.countryCapital = countryCapital;
        this.countryName = countryName;
        this.imgId = imgId;
    }

    public DataProvider() {
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public ArrayList<DataProvider> getAllData()
    {
        ArrayList<DataProvider> providers = new ArrayList<>();
        providers.add(new DataProvider("India","Delhi",R.drawable.ic_india));

        return providers;
    }
}
