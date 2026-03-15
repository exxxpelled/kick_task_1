package com.khmel.task.service;

import com.khmel.task.entity.IntArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface IntArrayAction {
  OptionalInt min(IntArray intArray);

  OptionalInt max(IntArray intArray);

  OptionalInt sum(IntArray intArray);

  OptionalDouble average(IntArray intArray);
}
