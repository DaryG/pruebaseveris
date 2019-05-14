package com.family.dao;

import org.springframework.data.repository.CrudRepository;

import com.family.entity.Family;

public interface IFamilyDao extends CrudRepository<Family, Integer> {

}
