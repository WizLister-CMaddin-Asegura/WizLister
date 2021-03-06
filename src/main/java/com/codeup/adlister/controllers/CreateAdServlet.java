package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Boolean.getBoolean;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, NullPointerException {



            User user = (User) request.getSession().getAttribute("user");

            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description"),
                    Long.parseLong(request.getParameter("category_id")),
//                    request.getParameter("created_date"),
//                    getBoolean(request.getParameter("is_active")),
//                    getBoolean(request.getParameter("is_seller")),
                    Double.parseDouble(request.getParameter("expected_price"))
//                    request.getParameter("last_updated")
            );
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");


    }
}
