package ua.ivashchuk.servlet;

import ua.ivashchuk.domain.Bucket;
import ua.ivashchuk.services.BucketService;
import ua.ivashchuk.services.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

//@WebServlet("/bucket")
//public class BucketController extends HttpServlet {
//
//    private BucketService bucketService = BucketServiceImpl.getBucketService();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String productId = request.getParameter("productId");
//
//        HttpSession session = request.getSession();
//        Integer userId = (Integer)session.getAttribute("userId");
//
//        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
//        try {
//            bucketService.create(bucket);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        response.setContentType("text");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("Success");
//
//    }
//
//}

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

    private	BucketService bucketService = BucketServiceImpl.getBucketService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");

        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        try {
            bucketService.create(bucket);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bucketId = req.getParameter("bucketId");
        try {
            bucketService.delete(Integer.parseInt(bucketId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}