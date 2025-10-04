

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginAction")
public class LoginAction extends GenericServlet {

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("un");
		String password=request.getParameter("pa");
		
		PrintWriter out=response.getWriter();
		if(user.equals(password)) {
			out.println("Login Successful");
		}else {
			out.println("Invalid Username/Password");
		}
	}

}
