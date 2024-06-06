package p1;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add")
public class RegServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws
	ServletException,IOException
	{
		RegistrationBean rb = new RegistrationBean();
		rb.setUsername(req.getParameter("uname"));
		rb.setPassword(req.getParameter("pword"));
		rb.setFirstname(req.getParameter("fname"));
		rb.setLastname(req.getParameter("lname"));
		rb.setAddress(req.getParameter("address"));
		rb.setMailId(req.getParameter("mailid"));
		rb.setPhno(Long.parseLong(req.getParameter("phno")));
		int k= new RegistrationDAO().register(rb);
		if(k>0)
		{
			req.setAttribute("msg","User Registration Successfully");
			RequestDispatcher rsd = req.getRequestDispatcher("Register.jsp");
			rsd.forward(req,res);
		}
		else
		{
			req.setAttribute("msg","User not Registration Successfully");
			RequestDispatcher rsd = req.getRequestDispatcher("Register.jsp");
			rsd.forward(req,res);
		}

	}
}
