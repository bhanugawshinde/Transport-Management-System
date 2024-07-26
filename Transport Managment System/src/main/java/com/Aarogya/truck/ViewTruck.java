package com.Aarogya.truck;

import java.io.IOException;

import com.Aarogya.DAO.TruckDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ViewTruck")
public class ViewTruck extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String var = req.getParameter("var");
		req.setAttribute("list", TruckDao.view());
		if(var!=null && var.equals("update")) {
			req.getRequestDispatcher("FrontEnd/pages/Truck/UpdateTruck.jsp").forward(req, resp);
		}
		else if(var!=null && var.equals("delete")) {
			req.getRequestDispatcher("FrontEnd/pages/Truck/DeleteTruck.jsp").forward(req, resp);

		}
		else {			
			req.getRequestDispatcher("FrontEnd/pages/Truck/ViewTruck.jsp").forward(req, resp);
		}
	}
}
