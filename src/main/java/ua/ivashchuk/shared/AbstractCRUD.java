package ua.ivashchuk.shared;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCRUD<T> {

    List<T> readAll() throws SQLException;
    T create(T t) throws SQLException;
    T read(Integer id) throws SQLException;
    T update(T t) throws SQLException;
    void delete(Integer id) throws SQLException;
}
