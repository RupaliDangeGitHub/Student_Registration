package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();

		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2 getting connection with mysql
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studregistration", "root", "root");

			// String sql2 = "insert into student values(" + n + ",'" + n1 + "'," + n2 +
			// ")";

			String sql = "select * from stud";

			PreparedStatement ps = con.prepareStatement(sql);

				
				ResultSet rs=ps.executeQuery();
			
				while(rs.next()) {
				
					pw.print(rs.getString(1) + "<br>");
					pw.print(rs.getString(2)+"<br>");
					pw.print(rs.getString(3)+"<br>");
					pw.print(rs.getString(4)+"<br>");
					
				}
				
				rs.close();
				
				
		} catch (Exception e) {
			// TODO: handle exception
		}

	
	
	}

}
