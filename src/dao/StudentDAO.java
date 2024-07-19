package dao;

import entities.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection con;

    public StudentDAO() {
        // Initialisez la connexion à la base de données ici
        String url = "jdbc:mysql://localhost/utilisateur";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void connexion() {
        String url = "jdbc:mysql://localhost/utilisateur";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                String mobile = resultSet.getString("mobile");
                String course = resultSet.getString("course");

                Student student = new Student();
                student.setId(id);
                student.setLastName(lastName);
                student.setFirstName(firstName);
                student.setMobile(mobile);
                student.setCourse(course);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student (lastName, firstName, mobile, course) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getMobile());
            preparedStatement.setString(4, student.getCourse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
//        this.connexion();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE student SET lastName = ?, firstName = ?, mobile = ?, course = ? WHERE id = ?");
            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getMobile());
            preparedStatement.setString(4, student.getCourse());
            preparedStatement.setInt(5, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
//        this.connexion();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM student WHERE id = ?");
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
