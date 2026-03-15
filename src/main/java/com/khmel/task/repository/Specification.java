package com.khmel.task.repository;

import com.khmel.task.entity.IntArray;

public interface Specification {
  boolean specify(IntArray intArray);
}
