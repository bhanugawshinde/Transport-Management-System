package com.Aarogya.truck;

import java.io.IOException;

import com.Aarogya.DAO.TruckDao;
import com.Aarogya.admin.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/Truck")
public class Truck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session!=null) {
			AdminBean adminBean = (AdminBean)session.getAttribute("adminBean");
			int totalTruck = TruckDao.getTotal();
			float maxPrice = TruckDao.getMaxPrice();
			float minPrice = TruckDao.getMinPrice();
			float totalPrice = TruckDao.getTotalPrice();
			float avgMileage = TruckDao.getAvarageMileage();
			int totalCompanies = TruckDao.getTotalCompanies();
			if(adminBean!=null) {
				req.setAttribute("totalTruck", totalTruck);
				req.setAttribute("maxPrice", maxPrice);
				req.setAttribute("minPrice", minPrice);
				req.setAttribute("totalPrice", totalPrice);
				req.setAttribute("avgMileage", avgMileage);
				req.setAttribute("totalCompanies", totalCompanies);
				req.getRequestDispatcher("FrontEnd/pages/Truck/Truck.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "Session Expaire");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
