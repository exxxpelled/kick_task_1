package com.khmel.task.service.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;
import com.khmel.task.service.IntArraySort;
import com.khmel.task.validator.IntArrayValidator;
import com.khmel.task.validator.impl.IntArrayValidatorImpl;

public class IntArraySortImpl implements IntArraySort {
  private static IntArrayValidator validator = new IntArrayValidatorImpl();

  @Override
  public IntArray bubbleSort(IntArray intArray) throws IntArrayException {
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
