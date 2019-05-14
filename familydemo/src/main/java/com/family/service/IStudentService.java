package com.family.service;

import java.util.List;

import com.family.entity.Student;

public interface IStudentService {
  public Student get(int studentId);

  public List<Student> getAll();

  public void post(Student student);

  public void put(Student student, int studentId);

  public void delete(int studentId);
}
