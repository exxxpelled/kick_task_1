package com.github.exxxpelled.task.service.impl;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exeption.IntArrayException;
import com.github.exxxpelled.task.service.IntArrayAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntArrayActionImpl implements IntArrayAction {
  private static Logger logger = LogManager.getLogger(IntArrayActionImpl.class);

  @Override
  public int min(IntArray intArray) throws IntArrayException {
    logger.info("Function min called");

    IntStream arrayStream = IntStream.of(intArray.getArray());
    OptionalInt min = arrayStream.min();
    int minAsInt = min.getAsInt();

    return minAsInt;
  }

  @Override
  public int max(IntArray intArray) throws IntArrayException {
    logger.info("Function max called");

    IntStream arrayStream = IntStream.of(intArray.getArray());
    OptionalInt max = arrayStream.max();
    int maxAsInt = max.getAsInt();

    return maxAsInt;
  }

  @Override
  public int sum(IntArray intArray) {
    logger.info("Function sum called");

    IntStream arrayStream = IntStream.of(intArray.getArray());
    int sum = arrayStream.sum();

    return sum;
  }
}