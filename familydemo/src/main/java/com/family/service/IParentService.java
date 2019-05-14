package com.family.service;

import java.util.List;

import com.family.entity.Parent;

public interface IParentService {
  public Parent get(int parentId);

  public List<Parent> getAll();

  public void post(Parent parent);

  public void put(Parent parent, int parentId);

  public void delete(int parentId);
}
