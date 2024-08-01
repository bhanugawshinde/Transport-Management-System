package com.Aarogya.employee;

import java.io.IOException;

import com.Aarogya.DAO.EmployeeDao;
import com.Aarogya.DAO.ManagerDao;
import com.Aarogya.admin.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Employee")
public class Employee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session!=null) {			
			AdminBean adminBean = (AdminBean)session.getAttribute("adminBean");
			int totalEmployee = EmployeeDao.getTotal();
			int totalManager = ManagerDao.getTotal();
			int totalDepartment = EmployeeDao.getTotalDepartment();
			
			float employeeMaxSalary = EmployeeDao.getMaxSalary();
			float employeeAvarageSalary = EmployeeDao.getAvarageSalary();
			
			float managerMaxSalary = ManagerDao.getMaxSalary();
			float managerAvarageSalary = ManagerDao.getAvarageSalary();
			
			if(adminBean!=null) {
				
				req.setAttribute("totalEmployee", totalEmployee);
				req.setAttribute("totalManager", totalManager);
				req.setAttribute("totalDepartment", totalDepartment);
				req.setAttribute("employeeMaxSalary", employeeMaxSalary);
				req.setAttribute("employeeAvarageSalary", employeeAvarageSalary);
				req.setAttribute("managerMaxSalary", managerMaxSalary);
				req.setAttribute("managerAvarageSalary", managerAvarageSalary);
				req.getRequestDispatcher("FrontEnd/pages/Employee/Employee.jsp").forward(req, resp);
				
			}
		}
		else {
			req.setAttribute("msg", "Session Expaire");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
