package com.khmel.task.validator.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.validator.IntArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayValidatorImpl implements IntArrayValidator {
  private static Logger logger = LogManager.getLogger(IntArrayValidatorImpl.class);

  @Override
  public boolean isIntArrayValid(IntArray intArray) {
    if (intArray == null || intArray.length() == 0) {
      logger.error("Array validation failed: array is null");
      return false;
    }
    return true;
  }
}
