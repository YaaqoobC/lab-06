package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = this.cities;
        Collections.sort(list);
        return list;
    }

    /**
     * When given a city, return whether or not it belongs in the list
     *
     * @param city
     * @return (boolean) True if contains False otherwise
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * When given a city, attempt to remove it from the list
     * If the city is not in the list throw an exception
     *
     * @param city
     * @return (void)
     * @throws Exception
     */
    public void delete(City city) throws Exception {
        if (hasCity(city)){
            this.cities.remove(city);
            return;
        }
        throw new Exception("City is NOT in the list!");
    }

    /**
     * Return the number of cities in the list
     *
     * @return (int) Returns the number of cities in the list
     */
    public int countCities() {
        return this.cities.size();
    }

}
