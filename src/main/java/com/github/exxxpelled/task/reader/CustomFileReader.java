package com.github.exxxpelled.task.reader;

import com.github.exxxpelled.task.exception.IntArrayException;

import java.util.List;

public interface CustomFileReader {
  List<String> readFile(String filePath) throws IntArrayException;
}
