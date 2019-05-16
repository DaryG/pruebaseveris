package com.family.dao;

import com.family.entity.Parent;

import org.springframework.data.repository.CrudRepository;



public interface IParentDao extends CrudRepository<Parent, Integer> {
}
