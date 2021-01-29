package by.eugene.telebot.service;


import by.eugene.telebot.dao.CityDAO;
import by.eugene.telebot.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;


    @Override
    @Transient
    public List<City> getAllCities() {


        return cityDAO.getAllCities();
    }

    @Override
    @Transactional
    public void saveCity(City city) {
        cityDAO.saveCity(city);

    }

    @Override
    @Transactional
    public City getCity(int id) {

        return cityDAO.getCity(id);
    }

    @Override
    @Transactional
    public void deleteCity(int id) {
            cityDAO.deleteCity(id);
    }



}
