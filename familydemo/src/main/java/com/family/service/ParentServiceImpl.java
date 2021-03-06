package com.family.service;

import com.family.dao.IParentDao;
import com.family.entity.Parent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements IParentService {

  @Autowired
  private IParentDao parentDao;

  @Override
  public Parent get(int parentId) {
    return parentDao.findById(parentId).get();
  }

  @Override
  public List<Parent> getAll() {
    return (List<Parent>) parentDao.findAll();
  }

  @Override
  public Parent post(Parent parent) {
    return parentDao.save(parent);
  }

  @Override
  public void put(Parent parent, int parentId) {
    parentDao.findById(parentId).ifPresent((p) -> {
      parent.setParentId(parentId);
      parentDao.save(parent);
    });
  }

  @Override
  public void delete(int parentId) {
    parentDao.deleteById(parentId);
  }

}
