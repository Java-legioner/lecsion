package ua.ivashchuk.dao;

import ua.ivashchuk.domain.User;
import ua.ivashchuk.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
    User getUserByEmail(String email);
}
