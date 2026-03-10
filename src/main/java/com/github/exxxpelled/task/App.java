package com.github.exxxpelled.task;

import com.github.exxxpelled.task.entity.IntArray;
import com.github.exxxpelled.task.exeption.IntArrayException;
import com.github.exxxpelled.task.factory.IntArrayFactory;
import com.github.exxxpelled.task.factory.impl.IntArrayFactoryImpl;
import com.github.exxxpelled.task.parser.CustomIntParser;
import com.github.exxxpelled.task.parser.impl.CustomIntParserImpl;
import com.github.exxxpelled.task.reader.CustomFileReader;
import com.github.exxxpelled.task.reader.impl.CustomFileReaderImpl;
import com.github.exxxpelled.task.service.IntArrayAction;
import com.github.exxxpelled.task.service.IntArraySort;
import com.github.exxxpelled.task.service.impl.IntArrayActionImpl;
import com.github.exxxpelled.task.service.impl.IntArraySortImpl;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.List;

public class App {
  private static Logger logger = LogManager.getLogger(App.class);
  private static final String FILE_PATH = "data/input.txt";

  public static void main(String[] args) throws IntArrayException {
    logger.info("Program has been started");


    CustomFileReader fileReader = new CustomFileReaderImpl();
    CustomIntParser parser = new CustomIntParserImpl();
    IntArrayFactory factory = new IntArrayFactoryImpl();
    IntArrayAction action = new IntArrayActionImpl();
    IntArraySort sorter = new IntArraySortImpl();

    List<String> readLines = fileReader.readFile(FILE_PATH);
    logger.info("File contains {} lines", readLines.size());

    if (readLines.isEmpty()) {
      logger.warn("File is empty. No data to process.");
      return;
    }

    for (int i = 0; i < readLines.size(); i++) {
      String line = readLines.get(i);
      logger.info("Processing line {}: '{}'", i + 1, line);

      try {
        int[] numbers = parser.parseString(line);

        IntArray intArray = factory.createIntArray(numbers);

        int min = action.min(intArray);
        int max = action.max(intArray);
        int sum = action.sum(intArray);

        logger.info("Line {} results - Min: {}, Max: {}, Sum: {}",
                i + 1, min, max, sum);

        IntArray bubbleSorted = sorter.bubbleSort(intArray);
        IntArray shellSorted = sorter.shellSort(intArray);

        logger.info("Line {} - Bubble sort completed", i + 1);
        logger.info("Line {} - Shell sort completed", i + 1);

      } catch (IntArrayException e) {
        logger.error("Error processing line {}: {}", i + 1, e.getMessage());
      }
    }

    logger.info("Program has been finished");
  }
}