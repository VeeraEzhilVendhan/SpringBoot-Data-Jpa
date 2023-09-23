package com.veera.SpringBootDataJpa.dao;

import com.veera.SpringBootDataJpa.entity.Student;

import java.util.List;

public interface StudentDAO
{
    public void saveStudent(Student s);

    public Student readStudent(int id);

    public void updateStudent(int id);

    public void deleteStudent(int id);

    public List<Student> getAllStudents();

    public int Query();
}
