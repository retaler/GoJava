package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.SortOfDataBase;
import com.donishchenko.airbnb.jdbc.DBUtils;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ApartmentDaoImpl implements ApartmentDao {
    public void save(Apartment apartment) {
        try {
            Connection conn = DBUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SortOfDataBase.apartments.put(apartment.getId(), apartment);
    }

    @Override
    public void delete(int id) {
        SortOfDataBase.apartments.remove(id);
    }

    public Apartment getById(int id) {
        return SortOfDataBase.apartments.get(id);
    }

    @Override
    public List<Apartment> getByCity(String city) {


        List<Apartment> list = new LinkedList<>();
        for (Apartment apartment : SortOfDataBase.apartments.values()) {
            if (apartment.getCity().equals(city)) {
                list.add(apartment);
            }
        }

        return list;
    }

    @Override
    public List<Apartment> getAll() {
        return new LinkedList<>(SortOfDataBase.apartments.values());
    }

    @Override
    public List<Apartment> getAllByUser(int id) {
        List<Apartment> list = new LinkedList<>();
        for (Apartment apartment : SortOfDataBase.apartments.values()) {
            if (apartment.getHost().getId() == id) {
                list.add(apartment);
            }
        }

        return list;
    }

    @Override
    public List<Apartment> getAllByUser(User user) {
        return getAllByUser(user.getId());
    }
}
