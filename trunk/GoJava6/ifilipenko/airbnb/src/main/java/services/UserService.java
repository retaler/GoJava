package services;

import dao.io.UserIODao;
import model.Home;
import model.User;

import java.io.IOException;

public class UserService {
    private UserIODao userIODao = new UserIODao();
    private HomeService service = new HomeService();

    public void userRegistration(User user) throws IOException {
        userIODao.create(user);
    }

    public User getUserByCode(int userCode) throws IOException {
        return userIODao.readUser(userCode);
    }

    public void becomeHost(int userCode, Home newHome) throws IOException {
        User host = this.getUserByCode(userCode);
        service.createHome(host, newHome);
    }

    public boolean searchPlace() {
        return false;
    }


}
