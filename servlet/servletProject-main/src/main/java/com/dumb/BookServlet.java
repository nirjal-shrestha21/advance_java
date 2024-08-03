package com.dumb;

import jakarta.servlet.ServletException;
import com.dumb.dao.DabaseOperation;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get all books and return dispatch to servlet
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Connection connection=null;
//		PreparedStatement psmt=null;
		   String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        String publication = request.getParameter("publication");
	        String price = request.getParameter("price");
		
		try {
			 Connection connection=DabaseOperation.dbConnect();
			String insrtquery="INSERT INTO books (title, author, publication, price) VALUES (?, ?, ?, ?)";
			PreparedStatement psmt=connection.prepareStatement(insrtquery);
			
			 psmt.setString(1, title);
             psmt.setString(2, author);
             psmt.setString(3, publication);
             psmt.setString(4, price);
             psmt.executeUpdate();
             response.getWriter().write("added successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
