package com.veera.SpringBootDataJpa;

import com.veera.SpringBootDataJpa.dao.StudentDAO;
import com.veera.SpringBootDataJpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO sDAO)
	{
		return runner ->
		{
			//save(sDAO);

			//Student s=read(sDAO);
			//System.out.println(s);

			//update(sDAO);

			//List<Student> list=getALl(sDAO);
			//System.out.println(list);

			//queryRun(sDAO);

			delete(sDAO);

		};
	}

	public void save(StudentDAO sDAO)
	{
		Student s1=new Student("arun","male","arun@gmail.com");
		sDAO.saveStudent(s1);
	}

	public Student read(StudentDAO sDAO)
	{
		return sDAO.readStudent(1);
	}

	public void update(StudentDAO sDAO)
	{
		sDAO.updateStudent(1);
	}

	public void delete(StudentDAO sDAO)
	{
		sDAO.deleteStudent(1);
	}

	public List<Student> getALl(StudentDAO sDAO)
	{
		return sDAO.getAllStudents();
	}

	public void queryRun(StudentDAO sDAO)
	{
		sDAO.Query();
	}

}
