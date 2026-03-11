package com.github.exxxpelled.task.reader.impl;

import com.github.exxxpelled.task.exception.IntArrayException;
import com.github.exxxpelled.task.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
  private static Logger logger = LogManager.getLogger(CustomFileReaderImpl.class);
  private static final String DEFAULT_FILE_PATH = "data/input.txt";

  @Override
  public List<String> readFile(String filePath) throws IntArrayException {
    if (filePath == null || filePath.isBlank()) {
      logger.error("File path is null or empty");
      throw new IntArrayException("File path is null or empty");
    }
    Path path = Paths.get(filePath);
    if (!Files.exists(path)) {
      logger.warn("File not found: {}. Using default path: {}", filePath, DEFAULT_FILE_PATH);
      filePath = DEFAULT_FILE_PATH;
      path = Paths.get(filePath);
    }

    try {
      List<String> result = Files.readAllLines(path);
      logger.info("Successfully read {} lines from file", result.size());
      return result;
    } catch (IOException exception) {
      logger.error("Failed to read file");
      throw new IntArrayException("Failed to read file");
    }
  }
}
