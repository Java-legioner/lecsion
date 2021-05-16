package ua.ivashchuk.services;

import ua.ivashchuk.domain.Product;
import ua.ivashchuk.shared.AbstractCRUD;

import java.sql.SQLException;
import java.util.Map;

public interface ProductService extends AbstractCRUD<Product> {
        public Map<Integer, Product> readAllMap() throws SQLException;
}
