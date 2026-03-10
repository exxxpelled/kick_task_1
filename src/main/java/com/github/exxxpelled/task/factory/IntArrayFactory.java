package com.github.exxxpelled.task.factory;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exeption.IntArrayException;

public interface IntArrayFactory {
  IntArray createIntArray(int[] array) throws IntArrayException;
}
