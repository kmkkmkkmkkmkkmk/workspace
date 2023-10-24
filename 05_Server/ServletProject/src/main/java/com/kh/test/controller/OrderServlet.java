package com.kh.test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resultPage")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String blackPen = req.getParameter("blackPen");
		String redPen = req.getParameter("redPen");
		String bluePen = req.getParameter("bluePen");
		String white = req.getParameter("white");
		
		System.out.println();
	}
}
