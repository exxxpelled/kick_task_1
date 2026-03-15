package com.khmel.task.repository.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.repository.Specification;
import com.khmel.task.service.IntArrayAction;
import com.khmel.task.service.impl.IntArrayActionImpl;

import java.util.OptionalInt;

public class SumEqualsSpecification implements Specification {
  private static IntArrayAction action;
  private int sum;

  public SumEqualsSpecification(int sum) {
    if (action == null) {
      action = new IntArrayActionImpl();
    }
    this.sum = sum;
  }

  @Override
  public boolean specify(IntArray intArray) {
    OptionalInt arraySum = action.sum(intArray);
    return arraySum.isPresent() && arraySum.getAsInt() == sum;
  }
}
