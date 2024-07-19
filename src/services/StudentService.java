/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Student;
import java.util.List;

/**
 *
 * @author DARIUS
 */
public interface StudentService {
    
    void create(Student student);
    
    void update(Student student);
    
    List<Student> getAllStudents();
    
    void delete(int id);
    
}
