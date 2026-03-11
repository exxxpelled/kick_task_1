package com.khmel.task.factory;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;

public interface IntArrayFactory {
  IntArray createIntArray(int[] array) throws IntArrayException;
}
