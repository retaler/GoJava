package com.gojava6.airbnb;

import com.gojava6.airbnb.model.*;
import com.gojava6.airbnb.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserService userService = (UserService) context.getBean("userService");
//        userService.createUser("Zhena", "Yarokh", "zhena.yarokh@gmail.com", UserType.CLIENT);
//        userService.createUser("Dima", "Tarasenko", "dima.tarasenko@gmail.com", UserType.CLIENT);
//        userService.createUser("Igor", "Lebedyuk", "igor.lebedyuk@gmail.com", UserType.CLIENT);
//        User user = userService.getUser(40);
//        userService.deleteUser(user);
//        userService.updateUserTypeToHost(user);
        userService.printAllUsers();

        System.out.println();

        ApartmentService apartmentService = (ApartmentService) context.getBean("apartmentService");
//        apartmentService.createApartment("Kiev", ApartmentType.APARTMENT, 40);
//        apartmentService.createApartment("Kiev", ApartmentType.APARTMENT, 40);
//        apartmentService.createApartment("Kiev", ApartmentType.ROOM, 40);
//        apartmentService.createApartment("Lviv", ApartmentType.APARTMENT, 40);
//        apartmentService.createApartment("Lviv", ApartmentType.ROOM, 40);
//        Apartment apartment = apartmentService.getApartment(33);
//        apartmentService.deleteApartment(apartment);
        apartmentService.printAllApartments();

        System.out.println();

        ReservationService reservationService = (ReservationService) context.getBean("reservationService");
//        reservationService.createReservation(29, 40, new Date(115, 8, 3), new Date(115, 8, 9));
//        reservationService.createReservation(29, 40, new Date(115, 8, 10), new Date(115, 8, 20));
//        Reservation reservation = reservationService.getReservation(1);
//        reservationService.deleteReservation(reservation);
//        reservationService.updateReservationDates(2, new Date(115, 8, 1), new Date(115, 8, 2));
        reservationService.printAllReservations();

        SearchService searchService = new SearchService();
        searchService.showSearchResults();
        searchService.filterByCity("Kiev");
        searchService.showSearchResults();
        searchService.filterByApartmentType(ApartmentType.APARTMENT);
        searchService.showSearchResults();
        searchService.filterByDates(new Date(115, 8, 1), new Date(115, 8, 20));
        searchService.showSearchResults();


//        User user1 = userService.getUser(37);
//        User user2 = userService.getUser(38);

        LoyaltyProgramService loyaltyProgramService = (LoyaltyProgramService) context.getBean("loyaltyProgramService");
        loyaltyProgramService.setLoyaltyProgramName("New Year loyalty program");
//        loyaltyProgramService.registerObserver(user1);
//        loyaltyProgramService.registerObserver(user2);
//        loyaltyProgramService.removeObserver(user1);
        loyaltyProgramService.setAvailable(true);

        System.out.println();

    }
}
