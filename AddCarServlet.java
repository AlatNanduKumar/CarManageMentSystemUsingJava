package com.car.mng.sytm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addCar")
public class AddCarServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int CarId= Integer.parseInt(req.getParameter("CarId"));
		String CarModell=req.getParameter("CarModell");
		String CarBrand=req.getParameter("CarBrand");	
		String CarColour=req.getParameter("CarColour");
		int CarPrice= Integer.parseInt(req.getParameter("CarPrice"));

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagementsystem?user=root&password=root");

			PreparedStatement pst=conn.prepareStatement("INSERT INTO car VALUES(?,?,?,?,?)");
			pst.setInt(1, CarId);
			pst.setString(2, CarModell);
			pst.setString(3, CarBrand);
			pst.setString(4, CarColour);
			pst.setInt(5, CarPrice);

			pst.executeUpdate();

			resp.sendRedirect("index.jsp");

		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
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


//jdbc:mysql://localhost:3306/database?user 
