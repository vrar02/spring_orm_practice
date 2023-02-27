package com.vivek.spring_orm_practice.dao;

import com.vivek.spring_orm_practice.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    void update(Student student);

    void delete(int id);

    Student get(int id);

    List<Student> getAll();


}
