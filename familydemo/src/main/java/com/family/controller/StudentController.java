package com.family.controller;

import com.family.entity.Student;
import com.family.service.IStudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  @Autowired
  IStudentService studentService;
  
  /**
   * Está función se encarga de listar a los estudiantes.
   * @return lista de estudiantes completa
   */
  @GetMapping("/students")
  public ResponseEntity<List<Student>> getAllStudents() {
    return new ResponseEntity<List<Student>>(studentService.getAll(),HttpStatus.OK);
  }
  
  /**
   * Se encarga de Listar a los estudiantes por su id.
   * @param studentId el id para poder hacer consulta.
   * @return Lista student específico por studentId
   */

  @GetMapping("/students/{studentId}")
  public Student getOne(@PathVariable(value = "studentId") int studentId) {
    return studentService.get(studentId);
  }
  
  
  /**
   * Está función se encarga de agregar a un student.
   * @param student ...
   */
  @PostMapping("/students")
  public ResponseEntity<Student> add(@RequestBody Student student) {
    return new ResponseEntity<Student>(studentService.post(student),HttpStatus.CREATED);
  }
 
  /**
   * Está función se encarga de actualizar a la entidad student.
   * @param student ...
   * @param studentId ...se requiere el id del student para hacer la actualización
   */
  @PutMapping("/students/{studentId}")
  public void update(@RequestBody Student student, @PathVariable int studentId) {
    studentService.put(student, studentId);
  }
  /**
   * Está función se encarga de hacer la eliminación de un estudent por id.
   * @param studentId ... se requiere el id del student para hacer la eliminación
   */
  
  @DeleteMapping(value = "/students/{studentId}")
  public void delete(@PathVariable Integer studentId) {
    studentService.delete(studentId);
  }
}
