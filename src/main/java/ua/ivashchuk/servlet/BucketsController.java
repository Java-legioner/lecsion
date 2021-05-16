package ua.ivashchuk.servlet;

import com.google.gson.Gson;
import ua.ivashchuk.domain.Bucket;
import ua.ivashchuk.domain.Product;
import ua.ivashchuk.dto.BucketDto;
import ua.ivashchuk.services.BucketService;
import ua.ivashchuk.services.ProductService;
import ua.ivashchuk.services.impl.BucketServiceImpl;
import ua.ivashchuk.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {

    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bucket> buckets = null;
        try {
            buckets = bucketService.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<Integer, Product> idToProduct = null;
        try {
            idToProduct = productService.readAllMap();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<BucketDto> listOfBucketDto  = map(buckets, idToProduct);

        String json = new Gson().toJson(listOfBucketDto);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public List<BucketDto> map(List<Bucket> buckets, Map<Integer,Product> idToProduct){
        return buckets.stream().map(bucket -> {
            BucketDto bucketDto = new BucketDto();
            bucketDto.bucketId = bucket.getId();
            bucketDto.purchaseDate = bucket.getPurchaseDate();

            Product product = idToProduct.get(bucket.getProductId());
            bucketDto.name = product.getName();
            bucketDto.description = product.getDescription();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());
    }
}
