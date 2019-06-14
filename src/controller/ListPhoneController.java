package controller;

import entity.Phone;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListPhoneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PhoneModel phoneModel = new PhoneModel();
        req.setAttribute("listPhone", phoneModel.select());
        req.getRequestDispatcher("listPhone.jsp").forward(req,resp);
    }
}
