package com.Aarogya.branch;

import java.io.IOException;

import com.Aarogya.DAO.BranchDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ViewBranch")
public class ViewBranch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String var = req.getParameter("var");
		req.setAttribute("list", BranchDao.view());
		if(var!=null && var.equals("update")) {
			req.getRequestDispatcher("FrontEnd/pages/Branch/UpdateBranch.jsp").forward(req, resp);
		}
		else if(var!=null && var.equals("delete")) {
			req.getRequestDispatcher("FrontEnd/pages/Branch/DeleteBranch.jsp").forward(req, resp);

		}
		else {			
			req.getRequestDispatcher("FrontEnd/pages/Branch/ViewBranch.jsp").forward(req, resp);
		}
	}
}
