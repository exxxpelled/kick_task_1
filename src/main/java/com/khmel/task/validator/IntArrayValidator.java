package com.khmel.task.validator;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;

public interface IntArrayValidator {
  boolean isIntArrayValid(IntArray intArray);
}
