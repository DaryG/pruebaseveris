package com.family.dao;

import com.family.entity.FamilyMember;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface IFamilyMemberDao extends CrudRepository<FamilyMember, Integer> {

  List<FamilyMember> findByFamilyFamilyId(int familyId);

}
