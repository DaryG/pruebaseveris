package com.family.controller;

import com.family.entity.Parent;
import com.family.service.IParentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {
  @Autowired
  IParentService parentService;

  @GetMapping("/parents")
  public List<Parent> getAllParents() {
    return parentService.getAll();
  }

  @GetMapping("/parents/{parentId}")
  public Parent getOne(@PathVariable(value = "parentId") int parentId) {
    return parentService.get(parentId);
  }

  @PostMapping("/parents")
  public void add(@RequestBody Parent parent) {
    parentService.post(parent);
  }

  @PutMapping("/parents/{parentId}")
  public void update(@RequestBody Parent parent, @PathVariable int parentId) {
    parentService.put(parent, parentId);
  }

  @DeleteMapping(value = "/parents/{parentId}")
  public void delete(@PathVariable Integer parentId) {
    parentService.delete(parentId);
  }
}
