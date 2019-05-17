package com.family.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * clase Entity Parent, desarrollamos la estructura de nuestra entidad parents, y las relaciones
 * con las otras entidades.
 * @author Dary Gonzales Cervera
 *
 */

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@Table(name = "Parents")
public class Parent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int parentId;
  @Column(name = "gender")
  private String gender;
  
  @Column(name = "first_name")
  private String firstName;
  
  @Column(name = "middle_name")
  private String middleName;
  
  @Column(name = "last_name")
  private String lastName;
  
  @Column(name = "other_parent_details")
  private String otherParentDetails;

  /**
   * Relación muchos a muchos con la entidad student.
   */
  
  @JsonIgnore
  @JoinTable(name = "student_parent", joinColumns = @JoinColumn(name = "parentId", 
      referencedColumnName = "parentId"), inverseJoinColumns = @JoinColumn(name = "studentId", 
      referencedColumnName = "studentId"))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Student> student;
  
  /**
   * Relación uno a uno con la entidad parents.
   */
  @JsonIgnore 
  @OneToOne(mappedBy = "parent")
  private Family family;




}
