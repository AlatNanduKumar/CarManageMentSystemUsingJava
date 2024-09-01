package com.car.mng.sytm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayAllCars")
public class DisplayAllCarss extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagementsystem?user=root&password=root");

			PreparedStatement pst=conn.prepareStatement("SELECT * FROM car");

			ResultSet rs=pst.executeQuery();
			req.setAttribute("ResultSet", rs);// What
			RequestDispatcher rd=req.getRequestDispatcher("DisplayAllCars.jsp");//Where
			rd.forward(req, resp);//Transfer


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
