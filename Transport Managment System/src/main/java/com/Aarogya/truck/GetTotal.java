package com.Aarogya.truck;

import java.io.IOException;

import com.Aarogya.DAO.TruckDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/GetTotal")
public class GetTotal extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = TruckDao.getTotal();
		req.setAttribute("total", total);
	}
}
