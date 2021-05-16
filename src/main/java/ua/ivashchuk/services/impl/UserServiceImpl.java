package ua.ivashchuk.services.impl;

import org.apache.log4j.Logger;
import ua.ivashchuk.dao.UserDao;
import ua.ivashchuk.dao.impl.UserDaoImpl;
import ua.ivashchuk.domain.User;
import ua.ivashchuk.services.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private static UserService userServiceImpl;
    private UserDao userDao;

    public UserServiceImpl(){
        try {
            userDao = new UserDaoImpl();
        }  catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static UserService getUserService(){
        if(userServiceImpl == null){
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    @Override
    public List<User> readAll() throws SQLException {
        return userDao.readAll();
    }

    @Override
    public User create(User user) throws SQLException {
        return userDao.create(user);
    }

    @Override
    public User read(Integer id) throws SQLException {
        return userDao.read(id);
    }

    @Override
    public User update(User user) throws SQLException {
        return userDao.update(user);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        userDao.delete(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
