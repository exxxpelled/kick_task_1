package com.github.exxxpelled.task.entity;

import com.github.exxxpelled.task.exeption.IntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntArray {
  private static Logger logger = LogManager.getLogger(IntArray.class);
  private int[] array;

  public IntArray(final int length) {
    this.array = new int[length];
    logger.info("IntArray created by size. Length: {}", length);
  }

  public IntArray(final int[] array) {
    this.array = array.clone();
    logger.info("IntArray created by other array. Length: {}", array.length);
  }

  public int length() {
    return this.array.length;
  }

  public int get(int index) throws IntArrayException {
    if (index < 0 || index >= array.length){
      logger.error("Index out of bounds");
      throw new IntArrayException("Index out of bounds");
    }

    return array[index];
  }

  public int[] getArray() {
    return array.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof IntArray otherIntArray)) return false;
    return Arrays.equals(array, otherIntArray.getArray());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(array);
  }
}
