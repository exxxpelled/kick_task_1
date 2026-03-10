package com.github.exxxpelled.task.validator;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exeption.IntArrayException;

public interface IntArrayValidator {
  void validateIntArray(IntArray intArray) throws IntArrayException;
}
