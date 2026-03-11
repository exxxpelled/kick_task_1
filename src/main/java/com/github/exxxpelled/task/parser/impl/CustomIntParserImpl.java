package com.github.exxxpelled.task.parser.impl;

import com.github.exxxpelled.task.exception.IntArrayException;
import com.github.exxxpelled.task.parser.CustomIntParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomIntParserImpl implements CustomIntParser {
  private static Logger logger = LogManager.getLogger(CustomIntParserImpl.class);
  private static final String SPLIT_CHAR = ";";

  @Override
  public int[] parseString(String line) throws IntArrayException {
    if (line == null || line.isBlank()){
      logger.error("Line is null or blank");
      throw new IntArrayException("Line is null or blank");
    }

    String[] splitLine = line.strip().split(SPLIT_CHAR);
    int[] possibleNumbers = new int[splitLine.length];
    for (int i = 0; i < splitLine.length; i++){
      try {
        String stripped = splitLine[i].strip();
        if (!stripped.isEmpty()) {
          possibleNumbers[i] = Integer.parseInt(stripped);
        } else {
          logger.error("Empty element found at position {}", i);
          throw new IntArrayException("Empty element found in line");
        }
      }
      catch (NumberFormatException exception){
        logger.error("Cannot parse element '{}' to integer", splitLine[i]);
        throw new IntArrayException("Cannot parse element '" + splitLine[i] + "' to integer");
      }
    }

    logger.info("Line was parsed into array of {} elements", possibleNumbers.length);
    return possibleNumbers;
  }
}