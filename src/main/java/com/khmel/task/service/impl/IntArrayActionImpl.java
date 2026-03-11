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
  public OptionalInt min(IntArray intArray) {
    logger.info("Function min called");
    OptionalInt min = IntStream.of(intArray.getArray()).min();
    return min;
  }

  @Override
  public OptionalInt max(IntArray intArray) {
    logger.info("Function max called");
    OptionalInt max = IntStream.of(intArray.getArray()).max();
    return max;
  }

  @Override
  public OptionalInt sum(IntArray intArray) {
    logger.info("Function sum called");
    int sum = IntStream.of(intArray.getArray()).sum();
    return OptionalInt.of(sum);
  }
}