package p1;

import java.beans.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String n = request.getParameter("name");
		String n1 = request.getParameter("email");
		String n2 = request.getParameter("address");
		String n3 = request.getParameter("mobno");

		PrintWriter pw = response.getWriter();
		pw.print("<h1>Student Registration</h1>");
		pw.print(n);
		pw.print("<br>");

		pw.print(n1);
		pw.print("<br>");

		pw.print(n2);
		pw.print("<br>");

		pw.print(n3);
		pw.print("<br>");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2 getting connection with mysql
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studregistration", "root", "root");

			// String sql2 = "insert into student values(" + n + ",'" + n1 + "'," + n2 +
			// ")";

			String sql = "insert into Stud values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, n);		
				ps.setString(2, n1);		
				ps.setString(3, n2);		
				ps.setString(4, n3);		
			
				int val=ps.executeUpdate();
			
				System.out.println(val);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
