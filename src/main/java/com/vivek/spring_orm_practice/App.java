package com.vivek.spring_orm_practice;

import com.vivek.spring_orm_practice.dao.StudentDao;
import com.vivek.spring_orm_practice.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@ComponentScan(basePackages = "com.vivek.spring_orm_practice")
public class App
{
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(App.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));

        SessionFactory sessionFactoryBean= context.getBean("sessionFactory", SessionFactoryImpl.class);
        System.out.println(sessionFactoryBean);
        StudentDao studentDao = (StudentDao) context.getBean("studentDaoImpl");

        System.out.println(studentDao.get(112));

        Student student=new Student(119,"hemant","banglore");

        studentDao.save(student);

        student.setName("hemanth");
        studentDao.update(student);

        List<Student> all = studentDao.getAll();
        for(Student student1:all ){
            System.out.println(student1);
        }

        studentDao.delete(118);


    }
}
