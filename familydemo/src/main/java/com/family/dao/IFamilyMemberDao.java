package com.family.dao;

import org.springframework.data.repository.CrudRepository;

import com.family.entity.FamilyMember;

public interface IFamilyMemberDao extends CrudRepository<FamilyMember, Integer> {

}
