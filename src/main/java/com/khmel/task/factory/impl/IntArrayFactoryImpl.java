package com.khmel.task.factory.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;
import com.khmel.task.factory.IntArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayFactoryImpl implements IntArrayFactory {
  private static Logger logger = LogManager.getLogger(IntArrayFactoryImpl.class);

  @Override
  public IntArray createIntArray(int[] array) throws IntArrayException {
    if (array == null || array.length == 0) {
      logger.error("Factory get invalid array");
      throw new IntArrayException("Factory get invalid array");
    }

    return new IntArray(array);
  }
}
