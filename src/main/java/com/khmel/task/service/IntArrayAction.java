package com.khmel.task.service;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;

public interface IntArrayAction {
  int min(IntArray intArray) throws IntArrayException;
  int max(IntArray intArray) throws IntArrayException;
  int sum(IntArray intArray) throws IntArrayException;
}
