package com.airbnb.model;

import org.apache.log4j.Logger;

/**
 * Created by Игорь on 26.09.2015.
 */
public class Apartment {
    private String apartmentType;
    private String city;
    private int ownerId;
    private int idAparnament;
    private static final Logger log = Logger.getLogger(Apartment.class);

    public Apartment(String apartmentType, String city, int ownerId) {
        this.apartmentType = apartmentType;
        this.city = city;
        this.ownerId = ownerId;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public String getCity() {
        return city;
    }

    public int getIdAparnament() {
        return idAparnament;
    }

    public void setIdAparnament(int idAparnament) {
        this.idAparnament = idAparnament;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return "Id: '" + this.idAparnament +
                "', Apartament type: '" + this.apartmentType +
                "', City: '" + this.city +
                "', Owner id: '" + this.ownerId + "'";
    }
}
