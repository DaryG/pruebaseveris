package com.family.service;

import com.family.dao.IStudentDao;
import com.family.entity.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private IStudentDao studentDao;

  @Override
  public Student get(int studentId) {
    return studentDao.findById(studentId).get();
  }

  @Override
  public List<Student> getAll() {
    return (List<Student>) studentDao.findAll();
  }

  @Override
  public Student post(Student student) {
    return studentDao.save(student);
  }

  @Override
  public void put(Student student, int studentId) {
    studentDao.findById(studentId).ifPresent((s) -> {
      student.setStudentId(studentId);
      studentDao.save(student);
    });
  }

  @Override
  public void delete(int studentId) {
    studentDao.deleteById(studentId);
  }

}
