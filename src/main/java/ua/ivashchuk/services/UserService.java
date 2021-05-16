package ua.ivashchuk.services;

import ua.ivashchuk.domain.User;
import ua.ivashchuk.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
    User getUserByEmail(String email);
}
