package com.family.service;

import java.util.List;

import com.family.entity.FamilyMember;

public interface IFamilyMemberService {
  public FamilyMember get(int familyMemberId);

  public List<FamilyMember> getAll();

  public void post(FamilyMember familyMember);

  public void put(FamilyMember familyMember, int familyMemberId);

  public void delete(int familyMemberId);
}
