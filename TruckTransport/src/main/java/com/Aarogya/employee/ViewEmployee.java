package com.Aarogya.employee;

import java.io.IOException;

import com.Aarogya.DAO.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String var = req.getParameter("var");
		req.setAttribute("list", EmployeeDao.view());
		if(var!=null && var.equals("update")) {
			req.getRequestDispatcher("FrontEnd/pages/Employee/UpdateEmployee.jsp").forward(req, resp);
		}
		else if(var!=null && var.equals("delete")) {
			req.getRequestDispatcher("FrontEnd/pages/Employee/DeleteEmployee.jsp").forward(req, resp);

		}
		else {			
			req.getRequestDispatcher("FrontEnd/pages/Employee/ViewEmployee.jsp").forward(req, resp);
		}
	}
}
