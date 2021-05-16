package ua.ivashchuk.servlet;

import com.google.gson.Gson;
import ua.ivashchuk.domain.Product;
import ua.ivashchuk.services.ProductService;
import ua.ivashchuk.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductsController extends HttpServlet {
    private ProductService productService = ProductServiceImpl.getProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = null;
        try {
            products = productService.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = new Gson().toJson(products);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
    }
}
