package ua.ivashchuk.services.impl;

import org.apache.log4j.Logger;
import ua.ivashchuk.dao.ProductDao;
import ua.ivashchuk.dao.impl.ProductDaoImpl;
import ua.ivashchuk.domain.Product;
import ua.ivashchuk.services.ProductService;
import ua.ivashchuk.services.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
    private static ProductService productServiceImpl;
    private ProductDao productDao;

    public ProductServiceImpl(){
        try {
            productDao = new ProductDaoImpl();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static ProductService getProductService(){
        if(productServiceImpl == null){
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }


    @Override
    public List<Product> readAll() throws SQLException {
        return productDao.readAll();
    }

    @Override
    public Product create(Product product) throws SQLException {
        return productDao.create(product);
    }

    @Override
    public Product read(Integer id) throws SQLException {
        return productDao.read(id);
    }

    @Override
    public Product update(Product product) throws SQLException {
        return productDao.update(product);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        productDao.delete(id);
    }


    @Override
    public Map<Integer, Product> readAllMap() throws SQLException {

        return readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
