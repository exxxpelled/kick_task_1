package com.github.exxxpelled.task.service;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exception.IntArrayException;

public interface IntArraySort {
  IntArray bubbleSort(IntArray intArray) throws IntArrayException;
  IntArray shellSort(IntArray intArray) throws IntArrayException;
}
