package com.family.service;

import com.family.entity.FamilyMember;

import java.util.List;



public interface IFamilyMemberService {
  public FamilyMember get(int familyMemberId);

  public List<FamilyMember> getAll();

  public FamilyMember post(FamilyMember familyMember, int familyId, String parentOrStudentMember, int id);

  public void put(FamilyMember familyMember, int familyMemberId);

  public void delete(int familyMemberId);
}
