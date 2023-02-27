package com.vivek.spring_orm_practice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="employee_info")
public class Employee {

    @Id
    private  int id;

    private String name;

}
