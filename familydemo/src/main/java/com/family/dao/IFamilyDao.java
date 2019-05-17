package com.family.dao;

import com.family.entity.Family;

import org.springframework.data.repository.CrudRepository;


public interface IFamilyDao extends CrudRepository<Family, Integer> {

}
