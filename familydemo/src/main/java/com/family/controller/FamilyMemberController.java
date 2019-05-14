package com.family.controller;

import com.family.entity.FamilyMember;
import com.family.service.IFamilyMemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping("/familymembers/{familyMemberId}")
  public FamilyMember getOne(@PathVariable(value = "familyMemberId") int familyMemberId) {
    return familyMemberService.get(familyMemberId);
  }

  @PostMapping("/familymembers/")
  public void add(@RequestBody FamilyMember familyMember) {
    familyMemberService.post(familyMember);
  }

  @PutMapping("/familymembers/{familyMemberId}")
  public void update(@RequestBody FamilyMember familyMember,
      @PathVariable(value = "familyMemberId") int familyMemberId) {
    familyMemberService.put(familyMember, familyMemberId);
  }
  
  @DeleteMapping(value = "/familymembers/{familyMemberId}")
  public void delete(@PathVariable Integer familyMemberId) {
    familyMemberService.delete(familyMemberId);
  }
}
