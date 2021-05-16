package ua.ivashchuk.services.impl;

import org.apache.log4j.Logger;
import ua.ivashchuk.dao.BucketDao;
import ua.ivashchuk.dao.impl.BucketDaoImpl;
import ua.ivashchuk.dao.impl.UserDaoImpl;
import ua.ivashchuk.domain.Bucket;
import ua.ivashchuk.services.BucketService;

import java.sql.SQLException;
import java.util.List;

public class BucketServiceImpl implements BucketService {

    private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
    private static BucketService bucketServiceImpl;

    private BucketDao bucketDao;

    public BucketServiceImpl(){
        try {
            bucketDao = new BucketDaoImpl();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static BucketService getBucketService(){
        if(bucketServiceImpl == null){
            bucketServiceImpl = new BucketServiceImpl();
        }
        return bucketServiceImpl;
    }


    @Override
    public List<Bucket> readAll() throws SQLException {
        return bucketDao.readAll();
    }

    @Override
    public Bucket create(Bucket bucket) throws SQLException {
        return bucketDao.create(bucket);
    }

    @Override
    public Bucket read(Integer id) throws SQLException {
        return bucketDao.read(id);
    }

    @Override
    public Bucket update(Bucket bucket) throws SQLException {
        return bucketDao.update(bucket);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        bucketDao.delete(id);
    }
}
