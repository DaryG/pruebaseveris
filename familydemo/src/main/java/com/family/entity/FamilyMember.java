package com.family.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * clase Entity FamilyMember, desarrollamos la estructura de nuestra entidad familymembers
 * y las relaciones con las otras entidades.
 * @author Dary Gonzales Cervera
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Family_Members")
public class FamilyMember {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "family_member_id")
  private int familyMemberId;

  @ManyToOne
  @JoinColumn(name = "family_id")
  private Family family;
  
  @Column(name = "parent_or_student_member")
  private String parentOrStudentMember;
  
  /**
   * Relación uno a uno con la entidad parents.
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "parent_id", nullable = true, referencedColumnName = "parentId")
  private Parent parent;
  
  /**
   * Relación uno a uno con la entidad students.
   */
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id", nullable = true, referencedColumnName = "studentId")
  private Student student;

  

}
