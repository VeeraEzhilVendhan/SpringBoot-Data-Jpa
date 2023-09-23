package com.veera.SpringBootDataJpa.dao;

import com.veera.SpringBootDataJpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO
{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student s)
    {
        entityManager.persist(s);
    }

    @Override
    @Transactional
    public Student readStudent(int id)
    {
        Student s=entityManager.find(Student.class,id);
        return s;
    }

    @Override
    @Transactional
    public void updateStudent(int id)
    {
        Student s=entityManager.find(Student.class,id);
        s.setEmail("john1@gmail.com");
        entityManager.merge(s);
    }

    @Override
    @Transactional
    public void deleteStudent(int id)
    {
        Student s=entityManager.find(Student.class,id);
        if(s!=null)
        {
            entityManager.remove(s);
        }
    }

    @Override
    @Transactional
    public List<Student> getAllStudents()
    {
       List<Student> list= entityManager.createQuery("from Student").getResultList();
       return list;
    }

    @Override
    @Transactional
    public int Query()
    {
       Query q= entityManager.createQuery("update Student set email='a@gmail.com' where id=:customId");
       q.setParameter("customId","1");
       int row = q.executeUpdate();
       return row;
    }
}
