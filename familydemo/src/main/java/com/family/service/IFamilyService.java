package com.family.service;

import com.family.entity.Family;

import com.family.entity.FamilyMember;

import java.util.List;



public interface IFamilyService {
  public Family get(int familyId);
  
  public List<FamilyMember> findByFamiliesFamily_id(int familyId);
  
  public List<Family> getAll();

  public Family post(Family family, int parentId);

  public void put(Family family, int familyId);
  
  public void patch(Family family, int familyId);

  public void delete(int familyId);
}
