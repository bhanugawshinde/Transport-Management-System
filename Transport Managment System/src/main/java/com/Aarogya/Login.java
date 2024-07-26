package com.Aarogya;

import java.io.IOException;
import java.io.PrintWriter;

import com.Aarogya.DAO.BranchDao;
import com.Aarogya.DAO.EmployeeDao;
import com.Aarogya.DAO.TruckDao;
import com.Aarogya.admin.AdminBean;
import com.Aarogya.admin.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int totalBranch = BranchDao.getTotal();
		int totalEmployee = EmployeeDao.getTotal();
		int totalTruck = TruckDao.getTotal();

		req.setAttribute("totalBranch", totalBranch);
		req.setAttribute("totalEmployee", totalEmployee);
		req.setAttribute("totalTruck", totalTruck);

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("adminBean") != null) {
			req.getRequestDispatcher("AdminDashboard.jsp").forward(req, resp);
		} else {
			String position = req.getParameter("position");
			String id = req.getParameter("id");
			String password = req.getParameter("password");

			if ("admin".equalsIgnoreCase(position)) {
				AdminBean adminBean = AdminDao.login(id, password);
				if (adminBean != null) {
					session = req.getSession();
					session.setAttribute("adminBean", adminBean);
					req.getRequestDispatcher("AdminDashboard.jsp").forward(req, resp);
				} else {
					PrintWriter out = resp.getWriter();
					out.print("Unable to Login");
					req.getRequestDispatcher("index.jsp").include(req, resp);
				}
			} else {
				// Handle other positions if needed
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int totalBranch = BranchDao.getTotal();
		int totalEmployee = EmployeeDao.getTotal();
		int totalTruck = TruckDao.getTotal();

		req.setAttribute("totalBranch", totalBranch);
		req.setAttribute("totalEmployee", totalEmployee);
		req.setAttribute("totalTruck", totalTruck);

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("adminBean") != null) {
			req.getRequestDispatcher("AdminDashboard.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("index.jsp").include(req, resp);
		}
	}
}
