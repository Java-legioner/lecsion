package ua.ivashchuk.servlet;

import ua.ivashchuk.domain.Product;
import ua.ivashchuk.services.ProductService;
import ua.ivashchuk.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    ProductService productService = ProductServiceImpl.getProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Product product = new Product(name, description,getValidatedPrice(price));
        try {
            productService.create(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("200");
    }

    private double getValidatedPrice(String price){
        if(price == null || price.isEmpty()){
            return 0;
        }
        return Double.parseDouble(price);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        Product product = null;
        try {
            product = productService.read(Integer.parseInt(productId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("product", product);
        request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
    }
}
