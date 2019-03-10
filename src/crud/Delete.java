package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bean.Student;
//@WebServlet("/Delete")
public class Delete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		
		 try {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	            String sql = "DELETE FROM Students WHERE id = ?";
	            PreparedStatement stat = (PreparedStatement) conn.prepareStatement(sql);
	            stat.setString(1,id);
	            int rs = stat.executeUpdate();
	            if (rs != 0) {
	                System.out.println("删除成功");
	            } else {
	                System.out.println("删除失败");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	
	}

}
