package com.github.exxxpelled.task.service.impl;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exception.IntArrayException;
import com.github.exxxpelled.task.service.IntArraySort;
import com.github.exxxpelled.task.validator.IntArrayValidator;
import com.github.exxxpelled.task.validator.impl.IntArrayValidatorImpl;

public class IntArraySortImpl implements IntArraySort {
  private static IntArrayValidator validator = new IntArrayValidatorImpl();

  @Override
  public IntArray bubbleSort(IntArray intArray) throws IntArrayException {
    validator.validateIntArray(intArray);

    int[] sortedArray = intArray.getArray();
    int n = sortedArray.length;

    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;

      for (int j = 0; j < n - i - 1; j++) {
        if (sortedArray[j] > sortedArray[j + 1]) {
          int temp = sortedArray[j];
          sortedArray[j] = sortedArray[j + 1];
          sortedArray[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }
    }

    return new IntArray(sortedArray);
  }

  @Override
  public IntArray shellSort(IntArray intArray) throws IntArrayException {
    validator.validateIntArray(intArray);

    int[] sortedArray = intArray.getArray();
    int n = sortedArray.length;

    for (int gap = n / 2; gap > 0; gap /= 2) {

      for (int i = gap; i < n; i++) {
        int temp = sortedArray[i];
        int j;

        for (j = i; j >= gap && sortedArray[j - gap] > temp; j -= gap) {
          sortedArray[j] = sortedArray[j - gap];
        }

        sortedArray[j] = temp;
      }
    }

    return new IntArray(sortedArray);
  }
}
