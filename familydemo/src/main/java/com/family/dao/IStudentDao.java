package com.family.dao;

import org.springframework.data.repository.CrudRepository;

import com.family.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Integer> {

}
