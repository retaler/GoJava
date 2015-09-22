package main;

import java.util.InputMismatchException;

/**
 * Created by user on 22.09.2015.
 */
public class Client extends User implements Observer {
    @Override
    public void update(Object obj) {

    }

    @Override
    public void loyalty(int discountPercent, Subject s) {
        System.out.println("Hello, "+getName()+". You have "+discountPercent+"% discount  on "+s.toString());
    }

    public Client (String name, String sername, String email) {
        if (this.setName(name)&&this.setSername(sername)&&this.setEmail(email)) {
            System.out.println("Successful Client registration");
        } else {
            throw new InputMismatchException();
        }
    }
    public String toString () {
        return this.getName()+" "+this.getSername();
    }
}
