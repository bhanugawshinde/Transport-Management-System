package com.Aarogya;

import java.io.IOException;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class filter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5501");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");
		if("OPTIONS".equalsIgnoreCase(((HttpServletRequest)req).getMethod())){
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			return;
		}
		chain.doFilter(req, resp);
	}

}
