package DAOImp;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Studentmodel;
import dao.StudentDAO;
import dbconnection.DbConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import cscorner.JavaServlet;

public class StudentDAOImp extends  HttpServlet implements StudentDAO{




    
    private final String SELECT_QUERY = "SELECT * FROM student";
	private final String INSERT_QUERY = "INSERT INTO student( naam,email,pasword,gender,mobile,address) VALUES (?,?,?,?,?,?)";
	
    @Override
	public List<Studentmodel> getAllStudent() {
		Connection connection;
        try {
            connection = DbConnection.getConnection();
            try {
            connection = DbConnection.getConnection();
       

			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ResultSet rst = ps.executeQuery();

			List<Studentmodel> catgList = new ArrayList<>();
                       
                       while (rst.next()) {
                      				Studentmodel catg = new Studentmodel();
				catg.setId(rst.getInt("id"));
				catg.setNamev(rst.getString("naam"));
				catg.setEmailv(rst.getString("email"));
				catg.setPasswordv(rst.getString("pasword"));
				catg.setGenderv(rst.getString("gender"));
				catg.setMobilev(rst.getString("mobile"));
				catg.setAddressv(rst.getString("address"));
                          
                               
				catgList.add(catg);
			}
			return catgList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        } catch (SQLException ex) {
        	
        	Logger.getLogger(StudentDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                return null;
	}
   
    
    	@Override
	public boolean addStudent(Studentmodel student) {
    		
                 boolean success=false;
		try {
                   Connection connection =  (Connection) DbConnection.getConnection();
                   
                   
			PreparedStatement ps = connection.prepareStatement("insert into student( naam,email,pasword,gender,mobile,address) values (?,?,?,?,?,?)");
//			ps.setInt(1, department.getId());
			ps.setString(1, student.getNamev());
           ps.setString(2,student.getEmailv());
         ps.setString(3,  student.getPasswordv());
			ps.setString(4, student.getGenderv());
	           ps.setString(5,student.getMobilev());
	         ps.setString(6,  student.getAddressv());
         ps.executeUpdate();
			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                       success=false;
			e.printStackTrace();
                        
		}
                return success;

	}
        
        

    
}

