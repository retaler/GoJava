package main;

import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by user on 19.09.2015.
 */
public class User implements Observer {
    private String name;
    private String sername;
    private String email;
    private Boolean isHost;
    public List<Apartment> apartments;
    //private String city;
    public final int clientId;


    public User (String name, String sername, String email){
        if (this.setName(name)&&this.setSername(sername)&&this.setEmail(email)) {
            this.isHost=false;
            clientId= (int) Math.random();
            System.out.println("Successful Host registration");
            Searches.hostList.add(this);
        } else {
            throw new InputMismatchException();
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        //to test
        if (name.isEmpty()||name.equals("Null")||name.matches(".*\\d+.*")) {return false;}
        this.name = name;
        return true;
    }

    public String getSername() {
        return sername;
    }

    public boolean setSername(String sername) {
        if (sername.isEmpty()||sername.equals("Null")||sername.matches(".*\\d+.*")) {return false;}
        this.sername = sername;
        return true;

    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email.isEmpty()||email.equals("Null")||!(email.contains("@"))) {return false;}
        this.email = email;
        return true;
    }

    public void setNewApartments (String next) {
        Apartment.ApartmentType type = Apartment.ApartmentType.valueOf(next);
        apartments.add(new Apartment(type, this, "Kyiv"));
    }

    public String toString(){
        return this.getName()/*+" in "+this.getCity()*/;
    }
/*

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
*/

    public void setLikeHost() { this.isHost=true;}


//    @Override
    public void update(Object obj) {

    }

//    @Override
    public void loyalty(int discountPercent, Subject s) {

        System.out.println("Hello, "+getName()+". You have "+discountPercent+"% discount  from "+s.toString());
    }
}
