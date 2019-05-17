package com.family.controller;

import com.family.entity.FamilyMember;
import com.family.service.IFamilyMemberService;

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
public class FamilyMemberController {
  @Autowired
  IFamilyMemberService familyMemberService;

  @GetMapping("/familymembers")
  public List<FamilyMember> getAllFamilyMembers() {
    return familyMemberService.getAll();
  }
  
  /**
   * Se encarga de Listar a los familymembers por su id.
   * @param familyMemberId el id para poder hacer consulta.
   * @return Lista familymembers específico por familyMemberId
   */
  @GetMapping("/familymembers/{familyMemberId}")
  public FamilyMember getOne(@PathVariable(value = "familyMemberId") int familyMemberId) {
    return familyMemberService.get(familyMemberId);
  }
  
  /**
   * Está función se encarga de agregar un obj familymembers.
   * @param familyMember inserta familymembers.
   * @param familyId se requiere del id de family para hacer el insert.
   * @param parentOrStudentMember se inserta si es student o parent.
   */
  
 
  @PostMapping("familymembers/{familyId}/{parentOrStudentMember}/{id}")
  public ResponseEntity<FamilyMember> add(@RequestBody FamilyMember familyMember, 
        @PathVariable(value = "familyId")int familyId,
        @PathVariable(value = "parentOrStudentMember") String parentOrStudentMember,
        @PathVariable(value = "id") int id) {
    return new ResponseEntity<FamilyMember>(familyMemberService.post(familyMember,
        familyId, parentOrStudentMember, id),HttpStatus.CREATED);
  }
        
  

  /**
   * Esta función se encarga de hacer la actualización de familymembers.
   * @param familyMember se actualizara la entidad familymembers
   * @param familyMemberId se requiere el id de familymembers para hacer la actualización.
   */
  @PutMapping("/familymembers/{familyMemberId}")
  public void update(@RequestBody FamilyMember familyMember,
      @PathVariable(value = "familyMemberId") int familyMemberId) {
    familyMemberService.put(familyMember, familyMemberId);
  }
  
  /**
   * Está función se encarga de hacer la eliminación de familymembers por id.
   * @param familyMemberId ... se requiere el id de familymembers para hacer la eliminación.
   */
  
  @DeleteMapping(value = "/familymembers/{familyMemberId}")
  public void delete(@PathVariable Integer familyMemberId) {
    familyMemberService.delete(familyMemberId);
  }
}
