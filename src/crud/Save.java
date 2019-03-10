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
//@WebServlet("/Save")
public class Save extends HttpServlet {

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
			String name = req.getParameter("name");
	        String sex = req.getParameter("sex");
	        String age =req.getParameter("age");
	        String phone = req.getParameter("phone");
	        String location = req.getParameter("location");


	        try {
	            Class.forName("com.mysql.jdbc.Driver");// 2.引入JDBC驱动器类
	            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	            String sql = "INSERT INTO Students(name,sex,age,phone,location) VALUES(?,?,?,?,?)";
	            PreparedStatement stat = (PreparedStatement) conn.prepareStatement(sql);
	            stat.setString(1, name);
	            stat.setString(2, sex);
	            stat.setInt(3, Integer.parseInt(age));
	            stat.setInt(4, Integer.parseInt(phone));
	            stat.setString(5, location);
	            int rs = stat.executeUpdate();
	            if (rs == 1) {
	                System.out.println("插入成功");
	            } else {
	                System.out.println("插入失败");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    
	}

}
