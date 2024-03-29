package com.webserv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webserv.dao.ProductDao;
import com.webserv.model.Product;

@WebServlet("/all")
public class GetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ProductDao productDao;
  
    public void init() {
    	productDao = new ProductDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productDao.getAll();
		request.setAttribute("products", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);
	}

}
