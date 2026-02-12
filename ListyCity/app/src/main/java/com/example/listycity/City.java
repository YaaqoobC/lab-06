package com.example.listycity;

/**
 * This is a class that defines a City.
 * It contains to string attributes, city, and province.
 * It contains two methods that get the two attributes.
 * There is only one constructor that requires params.
*/
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
    * Constructor Method
    * @param city a string of the city to set
    * @param province a string of the province to set
    * */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the private city value
     * @return the city string
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Returns the private province value
     * @return the province string
     */
    String getProvinceName() {
        return this.province;
    }

    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
