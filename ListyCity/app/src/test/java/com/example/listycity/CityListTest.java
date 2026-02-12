package com.example.listycity;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        // Ensure correct false return
        assertFalse(cityList.hasCity(mockCity()));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Ensure correct true return
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertTrue(cityList.hasCity(city));
        assertEquals(2, cityList.countCities());
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertThrows(Exception.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCountCities() throws Exception {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        cityList.delete(city);
        assertEquals(1, cityList.countCities());

        cityList.delete(cityList.getCities().get(0));
        assertEquals(0, cityList.countCities());
    }



}
