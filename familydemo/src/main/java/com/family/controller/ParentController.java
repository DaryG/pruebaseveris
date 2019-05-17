package com.family.controller;

import com.family.entity.Parent;
import com.family.service.IParentService;

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
public class ParentController {
  @Autowired
  IParentService parentService;

  /**
   * Está función se encarga de listar a los parents.
   * @return lista de parents completa
   */
  
  @GetMapping("/parents")
  public List<Parent> getAllParents() {
    return parentService.getAll();
  }

  /**
   * Se encarga de Listar a los parents por su id.
   * @param parentId el id para poder hacer consulta.
   * @return Lista parent específico por parentId
   */

  @GetMapping("/parents/{parentId}")
  public Parent getOne(@PathVariable(value = "parentId") int parentId) {
    return parentService.get(parentId);
  }
  
  /**
   * Está función se encarga de agregar a un parent.
   * @param parent inserta una entidad parent.
   */
  
  @PostMapping("/parents")
  public ResponseEntity<Parent> add(@RequestBody Parent parent) { 
    return new ResponseEntity<Parent>(parentService.post(parent),HttpStatus.CREATED);
  }
    
  /**
   * Esta función se encarga de hacer la actualización de la entidad parent.
   * @param parent se actualizara la entidad parent
   * @param parentId se requiere el id del parent para hacer la actualización.
   */
  @PutMapping("/parents/{parentId}")
  public void update(@RequestBody Parent parent, @PathVariable int parentId) {
    parentService.put(parent, parentId);
  }
  
  /**
   * Está función se encarga de hacer la eliminación de un parent por id.
   * @param parentId ... se requiere el id del parent para hacer la eliminación
   */

  @DeleteMapping(value = "/parents/{parentId}")
  public void delete(@PathVariable Integer parentId) {
    parentService.delete(parentId);
  }
}
