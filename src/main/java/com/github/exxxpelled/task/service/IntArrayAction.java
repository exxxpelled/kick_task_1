package com.github.exxxpelled.task.service;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exception.IntArrayException;

public interface IntArrayAction {
  int min(IntArray intArray) throws IntArrayException;
  int max(IntArray intArray) throws IntArrayException;
  int sum(IntArray intArray) throws IntArrayException;
}
