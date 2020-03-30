/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class Faculty implements EmailRecipient{
    
    String name;
    private String emailAddress;
    private List<Teacher> teachers = new ArrayList<>();
    
    public Faculty(String name, String emailAddress) {
            this.name = name;
            this.emailAddress = emailAddress;
        }
    
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.emailAddress;
    }

    public void addTeacher(Teacher t1) {
         teachers.add((Teacher) t1);
    }
    
    public List<Teacher> getTeachers() {
         return teachers;
    }
}
