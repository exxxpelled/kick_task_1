package com.khmel.task.repository.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.repository.Specification;

public class ElementsAmountHigherSpecification implements Specification {
  private int elementsAmount;

  public ElementsAmountHigherSpecification(int elementsAmount) {
    this.elementsAmount = elementsAmount;
  }

  @Override
  public boolean specify(IntArray intArray) {
    return intArray.length() >= elementsAmount;
  }
}
