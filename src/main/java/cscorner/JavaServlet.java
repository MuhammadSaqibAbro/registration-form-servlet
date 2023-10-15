package cscorner;

import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOImp.StudentDAOImp;
import dao.StudentDAO;
import model.Studentmodel;

import javax.servlet.RequestDispatcher;

@WebServlet("/JavaServlet")
public class JavaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public JavaServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	List<Studentmodel> list=new ArrayList();
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.write("<h1 style='color:blue; background-color:red'>Hello Welcome to Java EE</h1><br>");		
    	Studentmodel sm=new Studentmodel();
		StudentDAO sd=new StudentDAOImp();
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/myform.html");
//		dispatcher.include(request, response);	
		String nameS=request.getParameter("naam");
		String emailS=request.getParameter("email");
		String pasS=request.getParameter("pasword");
		String genderS=request.getParameter("gender");
		String mobileS=request.getParameter("mobile");
		String addressS=request.getParameter("address");
		

	
		sm.setNamev(nameS);
		sm.setEmailv(emailS);
		sm.setPasswordv(pasS);
		sm.setGenderv(genderS);
		sm.setMobilev(mobileS);
		sm.setAddressv(addressS);
		boolean success = sd.addStudent(sm);
		list=sd.getAllStudent();


		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Information</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("}");
        out.println("h2 {");
        out.println("    text-align: center;");
        out.println("}");
        out.println("table {");
        out.println("    border-collapse: collapse;");
        out.println("    width: 80%;");
        out.println("    margin: 0 auto;");
        out.println("    background-color: #fff;");
        out.println("    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".row {");
        out.println("    background-color: #00008B");
        out.println("    color: #fff;");
        out.println("}");
        out.println(".Allrow {");
        out.println("    background-color: #E9E9E9;");
        out.println("}");
        out.println("th, td {");
        out.println("    padding: 8px 12px;");
        out.println("    text-align: left;");
        out.println("    border: 1px solid #ddd;");
        out.println("}");
        out.println("th {");
        out.println("    background-color: #007BFF;");
        out.println("    color: #fff;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 style=\"color: white; background-color: blue; text-align: center; display: inline-block; padding: 10px; margin: 0 auto;\"> "
        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Information &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        		+ "&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;"
        		+ " &nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;</h2>");



        out.println("<br><br><table>");
        out.println("<tr class=\"row\"><th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Gender</th><th>Mobile</th><th>Address</th></tr>");
        
		for(Studentmodel m:list) {
			
			 
			 out.println("<tr class=\"Allrow\"><td><h3>" + m.getId() + "</h3></td><td>" + m.getNamev() + "</td><td>" + m.getEmailv() + "</td><td>" + m.getPasswordv() + "</td><td>" + m.getGenderv() + "</td><td>" + m.getMobilev() + "</td><td>" + m.getAddressv() + "</td></tr>");
			   
	        
	        

			

		}	
	    out.println("</table>");
        out.println("</body>");
        out.println("</html>");
	
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);					
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/form.html");
//			dispatcher.include(request, response);	
    }
}
