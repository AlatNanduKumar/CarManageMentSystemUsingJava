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
@WebServlet("/updateCar")
public class UpdateCar extends HttpServlet {
	Connection conn = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int CarId=Integer.parseInt(req.getParameter("CarId"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagementsystem?user=root&password=root");

			PreparedStatement pst=conn.prepareStatement("SELECT * FROM car WHERE CarId=?");
			pst.setInt(1, CarId);

			ResultSet rs=pst.executeQuery();

			req.setAttribute("ResultSet", rs);
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			resp.sendRedirect("DisplayAllCars");


		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
