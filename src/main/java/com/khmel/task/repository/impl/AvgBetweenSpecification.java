package com.khmel.task.repository.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.repository.Specification;
import com.khmel.task.service.IntArrayAction;
import com.khmel.task.service.impl.IntArrayActionImpl;

import java.util.OptionalDouble;

public class AvgBetweenSpecification implements Specification {
  private static IntArrayAction action;
  private int minAvg;
  private int maxAvg;

  public AvgBetweenSpecification(int minAvg, int maxAvg) {
    if (action == null) {
      action = new IntArrayActionImpl();
    }
    this.minAvg = minAvg;
    this.maxAvg = maxAvg;
  }

  @Override
  public boolean specify(IntArray intArray) {
    OptionalDouble arrayAverage = action.average(intArray);
    return arrayAverage.isPresent() && arrayAverage.getAsDouble() >= minAvg && arrayAverage.getAsDouble() <= maxAvg;
  }
}
