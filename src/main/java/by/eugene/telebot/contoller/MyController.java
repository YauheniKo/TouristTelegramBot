package by.eugene.telebot.contoller;



import by.eugene.telebot.entity.City;
import by.eugene.telebot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> showAllCities() {
        List<City> allCities = cityService.getAllCities();
        return allCities;
    }

    @GetMapping("/cities/{id}")
    public City getCity (@PathVariable int id) {
        City city = cityService.getCity(id);

        return city;
    }


    @PostMapping("/cities")
    public City addNewCity (@RequestBody City city) {
        cityService.saveCity(city);
        return city;
    }

    @PutMapping("/cities")
    public City updateCity (@RequestBody City city) {
        cityService.saveCity(city);
        return city;
    }

    @DeleteMapping("/cities/{id}")
    public String deleteCity (@PathVariable int id) {
        cityService.deleteCity(id);
        return "City with ID = " +id + " was delete";
    }


}
