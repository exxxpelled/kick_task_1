package com.khmel.task.service.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;
import com.khmel.task.service.IntArrayAction;
import com.khmel.task.validator.IntArrayValidator;
import com.khmel.task.validator.impl.IntArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntArrayActionImpl implements IntArrayAction {
  private static Logger logger = LogManager.getLogger(IntArrayActionImpl.class);
  private static final IntArrayValidator validator = new IntArrayValidatorImpl();

  @Override
  public int min(IntArray intArray) throws IntArrayException {
    validator.validateIntArray(intArray);
    logger.info("Function min called");

    IntStream arrayStream = IntStream.of(intArray.getArray());
    OptionalInt min = arrayStream.min();
    int minAsInt = min.getAsInt();

    return minAsInt;
  }

  @Override
  public int max(IntArray intArray) throws IntArrayException {
    validator.validateIntArray(intArray);
    logger.info("Function max called");

    IntStream arrayStream = IntStream.of(intArray.getArray());
    OptionalInt max = arrayStream.max();
    int maxAsInt = max.getAsInt();

    return maxAsInt;
  }

  @Override
  public int sum(IntArray intArray) throws IntArrayException {
    validator.validateIntArray(intArray);
    logger.info("Function sum called");

    IntStream arrayStream = IntStream.of(intArray.getArray());
    int sum = arrayStream.sum();

    return sum;
  }
}