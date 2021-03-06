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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * clase Entity Family, desarrollamos la estructura de nuestra entidad families, y las relaciones
 * con las otras entidades, uno a uno y muchos a muchos.
 * @author Dary Gonzales
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Families")
public class Family {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "family_id")
  private int familyId;
   
  @Column(name = "family_name")
  private String familyName;
  
  
  /**
   * Relación uno a uno con parents.  
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "head_of_family_parent_id", referencedColumnName = "parentId")
  private Parent parent;
  
  /**
  * Relación uno a muchos con familymembers.
  */
  @JsonIgnore
  @OneToMany(mappedBy = "family")
  private List<FamilyMember> familyMemberList;
  
}
