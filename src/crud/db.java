package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import bean.Student;
//@WebServlet("/DB")
public class db extends HttpServlet {

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
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	            Statement stmt = (Statement) conn.createStatement();
	            ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM Students");
	            List<Student> list = new ArrayList<>();
	            //System.out.println("获取数据库的信息如下");
	            // total
	            int total = 0;
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String sex = rs.getString("sex");
	                int age = rs.getInt("age");
	                int phone = rs.getInt("phone");
	                String location = rs.getString("location");
	                Student student = new Student(id, name,sex ,age,phone,location);
	               // System.out.println(student);
	                list.add(student);
	            }
	            Gson gson = new Gson();
	            String json = gson.toJson(list);
	            //System.out.println(json);
	            total = list.size();
	            //System.out.println(total);

	            // 将JSON字符串作为响应数据返回
	            resp.setContentType("text/json;charset=UTF-8");
	            PrintWriter writer = resp.getWriter();
	            //writer.write(json);

	            String str="{\"total\":"+list.size()+" ,\"rows\":"+json+"}";
				resp.getWriter().write(str);
				//System.out.println(str);

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
