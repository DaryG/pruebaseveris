package com.family.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * clase Entity Parent, desarrollamos la estructura de nuestra entidad parents, y las relaciones
 * con las otras entidades.
 * @author Dary Gonzales Cervera
 *
 */

@EqualsAndHashCode(exclude = "parent")
@Entity
@Getter 
@Setter 
@NoArgsConstructor
@Table(name = "Students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;
  @Column(name = "gender")
  private String gender;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "date_of_birth")
  private Date dateOfBirth;
  @Column(name = "other_student_details")
  private String otherStudentDetails;
  
  /**
   * Relación muchos a muchos con la entidad parents.
   */
  @JsonIgnore
  @ManyToMany(mappedBy = "student")
  private List<Parent> parent;

}

  

