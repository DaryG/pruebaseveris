package com.family.service;

import com.family.dao.IFamilyDao;
import com.family.dao.IFamilyMemberDao;
import com.family.dao.IParentDao;
import com.family.entity.Family;
import com.family.entity.FamilyMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements IFamilyService {

  @Autowired
  private IFamilyDao familyDao;
  
  @Autowired
  private IParentDao parentDao;
  
  @Autowired
  private IFamilyMemberDao familyMemberDao;

  @Override
  public Family get(int familyId) {
    return familyDao.findById(familyId).get();
  }

  @Override
  public List<Family> getAll() {
    return (List<Family>) familyDao.findAll();
  }

  @Override
  public void post(Family family, int parentId) {
	  parentDao.findById(parentId).ifPresent((p) ->{
		  family.setParent(p);
		  familyDao.save(family);
	  });
	    
  }
  @Override
  public void put(Family family, int familyId) {
    familyDao.findById(familyId).ifPresent((f) -> {
      family.setFamilyId(familyId);
      familyDao.save(family);
    });
  }

  @Override
  public void delete(int familyId) {
    familyDao.deleteById(familyId);
  }

@Override
public List<FamilyMember> getFamilyMembers(int familyId) {
	
	return (List<FamilyMember>) familyMemberDao.findByFamilyFamilyId(familyId);
}

@Override
public void patch(Family family, int familyId) {
	 familyDao.findById(familyId).ifPresent((f) -> {
	      family.setFamilyId(familyId);
	      familyDao.save(family);
	    });
	
}



}
