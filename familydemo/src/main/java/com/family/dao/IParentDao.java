package com.family.dao;

import org.springframework.data.repository.CrudRepository;

import com.family.entity.Parent;

public interface IParentDao extends CrudRepository<Parent, Integer> {
}
