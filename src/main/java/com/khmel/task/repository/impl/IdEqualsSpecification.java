package com.khmel.task.repository.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.repository.Specification;

public class IdEqualsSpecification implements Specification {
  private int id;

  public IdEqualsSpecification(int id) {
    this.id = id;
  }

  @Override
  public boolean specify(IntArray intArray) {
    return intArray.getId() == id;
  }
}
