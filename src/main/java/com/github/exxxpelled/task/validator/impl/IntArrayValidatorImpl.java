package com.github.exxxpelled.task.validator.impl;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exeption.IntArrayException;
import com.github.exxxpelled.task.validator.IntArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayValidatorImpl implements IntArrayValidator {
  private static Logger logger = LogManager.getLogger(IntArrayValidatorImpl.class);

  @Override
  public void validateIntArray(IntArray intArray) throws IntArrayException {
    if (intArray == null) {
      logger.error("Array validation failed: array is null");
      throw new IntArrayException("IntArray is null");
    }
  }
}
