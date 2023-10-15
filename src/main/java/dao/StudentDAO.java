package dao;


import java.util.List;
import model.Studentmodel;

public interface StudentDAO {
	   public List<Studentmodel> getAllStudent();
	    public boolean addStudent(Studentmodel student);
}
