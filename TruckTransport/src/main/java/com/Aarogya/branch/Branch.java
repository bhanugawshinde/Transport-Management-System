package com.Aarogya.branch;

import java.io.IOException;

import com.Aarogya.DAO.BranchDao;
import com.Aarogya.admin.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/Branch")
public class Branch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session!=null) {
			AdminBean adminBean = (AdminBean)session.getAttribute("adminBean");
			int total = BranchDao.getTotal();
			int state = BranchDao.getTotalState();
			int manager = BranchDao.getTotalManager();
			int active = BranchDao.getTotalActive();
			if(adminBean!=null) {
				req.setAttribute("total", total);
				req.setAttribute("state", state);
				req.setAttribute("manager", manager);
				req.setAttribute("active", active);
				req.getRequestDispatcher("FrontEnd/pages/Branch/Branch.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Session Expaire");
				req.setAttribute("cls", "error");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "Session Expaire");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
