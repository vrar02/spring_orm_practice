package com.vivek.spring_orm_practice.dao;

import com.vivek.spring_orm_practice.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public class StudentDaoImpl implements StudentDao{


    private HibernateTemplate hibernateTemplate;

    @Autowired
    public StudentDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    @Transactional
    public void save(Student student) {
        this.hibernateTemplate.save(student);
    }

    @Transactional
    public void update(Student student) {
        this.hibernateTemplate.update(student);
    }


    @Transactional
    public void delete(int id) {
        Student student = this.hibernateTemplate.get(Student.class, id);
        this.hibernateTemplate.delete(student);
    }


    public Student get(int id) {
        Student student = this.hibernateTemplate.get(Student.class, id);
        return student;
    }


    public List<Student> getAll() {

        List<Student> studentList = this.hibernateTemplate.loadAll(Student.class);
        return studentList;
    }
}
