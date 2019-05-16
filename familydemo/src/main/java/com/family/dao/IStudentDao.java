package com.family.dao;

import com.family.entity.Student;

import org.springframework.data.repository.CrudRepository;



public interface IStudentDao extends CrudRepository<Student, Integer> {

}
