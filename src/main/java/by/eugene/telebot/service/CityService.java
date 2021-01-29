package by.eugene.telebot.service;




import by.eugene.telebot.entity.City;

import java.util.List;

public interface CityService {

    public List<City> getAllCities();

    public void saveCity(City city);

    public City getCity(int id);

    public void deleteCity(int id);


}
