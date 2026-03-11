package com.khmel.task.parser;

import com.khmel.task.exception.IntArrayException;

public interface CustomIntParser {
  int[] parseString(String line) throws IntArrayException;
}
