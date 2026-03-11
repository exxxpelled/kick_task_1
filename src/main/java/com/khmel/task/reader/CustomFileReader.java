package com.khmel.task.reader;

import com.khmel.task.exception.IntArrayException;

import java.util.List;

public interface CustomFileReader {
  List<String> readFile(String filePath) throws IntArrayException;
}
