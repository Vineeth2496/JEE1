

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		Integer userId=Integer.parseInt(uid);
		String password=request.getParameter("pa");
		String fullName=request.getParameter("fn");
		String email=request.getParameter("em");
		String gender=request.getParameter("gn");
		String country=request.getParameter("con");
		
		PrintWriter out=response.getWriter();
		
//		out.println(userId);
//		out.println(password);
//		out.println(fullName);
//		out.println(email);
//		out.println(gender);
//		out.println(country);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nacs1", "root", "vine96");
			
			System.out.println(con);
			
			PreparedStatement pst=con.prepareStatement("insert into jee1 values(?,?,?,?,?,?)");
			
			pst.setInt(1, userId);
			pst.setString(2, password);
			pst.setString(3, fullName);
			pst.setString(4, email);
			pst.setString(5, gender);
			pst.setString(6, country);
			
			int i=pst.executeUpdate();
			
			if(i>0) {
				
				out.println("<html>");
				out.println("<center>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				
				rd.include(request, response);
				out.println("Account is Registerd Successfully");
				out.println("</center>");
				out.println("</html>");
			}else {
				out.println("<html>");
				out.println("<center>");
				RequestDispatcher rd=request.getRequestDispatcher("Register.html");
				
				rd.include(request, response);
				out.println("Something Went Wrong");
				out.println("</center>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
