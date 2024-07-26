package com.Aarogya.customer;

import java.io.IOException;

import com.Aarogya.admin.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/Customer")
public class Customer extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session!=null) {
			AdminBean adminBean = (AdminBean)session.getAttribute("adminBean");
			if(adminBean!=null) {
				req.getRequestDispatcher("FrontEnd/pages/Customer/Customer.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "Session Expaire");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
