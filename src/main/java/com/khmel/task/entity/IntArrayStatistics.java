package com.khmel.task.entity;

import com.khmel.task.service.IntArrayAction;
import com.khmel.task.service.impl.IntArrayActionImpl;

public class IntArrayStatistics {
  private int min;
  private int max;
  private int sum;
  private double average;

  public IntArrayStatistics(int min, int max, int sum, double average) {
    this.min = min;
    this.max = max;
    this.sum = sum;
    this.average = average;
  }

  public IntArrayStatistics(IntArray intArray) {
    IntArrayAction action = new IntArrayActionImpl();

    this.min = action.max(intArray).orElse(0);
    this.max = action.max(intArray).orElse(0);
    this.sum = action.sum(intArray).orElse(0);
    this.average = action.average(intArray).orElse(0);
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }
}
