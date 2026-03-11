package com.khmel.task.service;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;

public interface IntArraySort {
  IntArray bubbleSort(IntArray intArray) throws IntArrayException;

  IntArray shellSort(IntArray intArray) throws IntArrayException;
}
