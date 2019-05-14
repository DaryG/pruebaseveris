package com.family.service;

import java.util.List;

import com.family.entity.Family;

public interface IFamilyService {
  public Family get(int familyId);

  public List<Family> getAll();

  public void post(Family family);

  public void put(Family family, int familyId);

  public void delete(int familyId);
}
