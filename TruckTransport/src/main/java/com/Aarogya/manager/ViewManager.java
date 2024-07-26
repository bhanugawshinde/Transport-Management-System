package com.Aarogya.manager;

import java.io.IOException;

import com.Aarogya.DAO.ManagerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ViewManager")
public class ViewManager extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String var = req.getParameter("var");
		req.setAttribute("list", ManagerDao.view());
		if(var!=null && var.equals("update")) {
			req.getRequestDispatcher("FrontEnd/pages/Employee/UpdateManager.jsp").forward(req, resp);
		}
		else if(var!=null && var.equals("delete")) {
			req.getRequestDispatcher("FrontEnd/pages/Employee/DeleteManager.jsp").forward(req, resp);

		}
		else {			
			req.getRequestDispatcher("FrontEnd/pages/Employee/ViewManager.jsp").forward(req, resp);
		}
	}
}
