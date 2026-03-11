package com.github.exxxpelled.task.parser;

import com.github.exxxpelled.task.exception.IntArrayException;

public interface CustomIntParser {
  int[] parseString(String line) throws IntArrayException;
}
