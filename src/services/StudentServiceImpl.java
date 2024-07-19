package services;

import dao.StudentDAO;
import entities.Student;
import java.util.List;


public class StudentServiceImpl implements StudentService {
    
    private StudentDAO studentDAO;

    @Override
    public void create(Student student) {
        studentDAO = new StudentDAO();
        studentDAO.addStudent(student);
    }

    @Override
    public void update(Student student) {
        studentDAO = new StudentDAO();
        this.studentDAO.updateStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        studentDAO = new StudentDAO();
        return this.studentDAO.getAllStudents();
    }

    @Override
    public void delete(int id) {
        studentDAO = new StudentDAO();
        this.studentDAO.deleteStudent(id);
    }
    
}
