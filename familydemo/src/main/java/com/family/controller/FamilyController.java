package com.family.controller;

import com.family.entity.Family;
import com.family.entity.FamilyMember;
import com.family.service.IFamilyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maneja solicitudes HTTP a families.
 * @author Dary Gonzales
 *
 */
@RestController
public class FamilyController {
  @Autowired
  IFamilyService familyService;
  
  /**
   * Esta función se escarga de listar a families.
   * @return Lista de familias.
   * 
   */
  
  @GetMapping("/families")
  public ResponseEntity<List<Family>> getAllFamilies() {
    return new ResponseEntity<List<Family>>(familyService.getAll(), HttpStatus.OK);
  }
  
  /**
  * regresa una lista de familia especifica por el id de families.
  * @param familyId id de families.
  * @return retorna una lista de familia específica por id.
  */
  
  @GetMapping("/families/{familyId}")
  public Family getOne(@PathVariable(value = "familyId") int familyId) {
    return familyService.get(familyId);
  }
  
  /**
   * Esta funcion hace la consulta de family.
   * @param familyId ...
   * @return retorna a los miembros de family.
   */
  
  @GetMapping("families/{familyId}/members")
  public List<FamilyMember> getFamilyMembers(@PathVariable(value = "familyId") int familyId) {
    return familyService.findByFamiliesFamily_id(familyId);
  }
  
  /**
   * esta función hace insert de un obj family.
   * @param family inserta un obj family.
   * @param parentId se requiere del parametro id de parent para poder hacer el insert.
   */
 
  @PostMapping("/families/{parentId}")
  public void add(@RequestBody Family family, @PathVariable int parentId) {
    familyService.post(family, parentId);
  }

  /**
   * Esta función hace la actualización de family.
   * @param family actualiza a family.
   * @param familyId se requiere del parametro id para poder hacer la actualización de family.
   */
  
  @PutMapping("/families/{familyId}")
  public void update(@RequestBody Family family, @PathVariable int familyId) {
    familyService.put(family, familyId);
  }
  
  /**
   * ...
   * @param family ...
   * @param familyId ...
   */
  
  @PatchMapping("/families/{familyId}")
  public void patch(@RequestBody Family family, @PathVariable int familyId) {
    familyService.patch(family, familyId);
  }
  
  /**
   * Esta función realiza la eliminación por id.
   * @param familyId se requiere del parametro id para poder hacer la eliminación específica.
   */

  @DeleteMapping(value = "/families/{familyId}")
  public void delete(@PathVariable Integer familyId) {
    familyService.delete(familyId);
  }
}
