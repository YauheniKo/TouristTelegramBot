package by.eugene.telebot.dao;



import by.eugene.telebot.entity.City;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
       public List<City> getAllCities() {
        Session session = entityManager.unwrap(Session.class);

        Query<City> query = session.createQuery("from City", City.class);

        List<City> allCities = query.getResultList();
        return allCities;
    }

    @Override
    public void saveCity(City city) {

        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);

    }

    @Override
    public City getCity(int id) {

        Session session = entityManager.unwrap(Session.class);

        City city = session.get(City.class, id);
        return city;
    }




    @Override
    public void deleteCity(int id) {

        Session session = entityManager.unwrap(Session.class);
        Query<City> query = session.createQuery("delete from City " +
                "where id =:cityId");

        query.setParameter("cityId", id);
        query.executeUpdate();

    }
}
