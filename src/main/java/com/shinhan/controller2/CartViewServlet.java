package com.shinhan.controller2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartViewServlet
 */
@WebServlet("/cart/cartview.do")
public class CartViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		if(obj!=null) {
			HashMap<String, Integer> cart = (HashMap<String, Integer>)obj;
			for(String key  : cart.keySet()) {
				System.out.println(key + "===>" + cart.get(key));
			}
		}*/
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("cartview.jsp");
		rd.forward(request, response);
	}

	 

}
