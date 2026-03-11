package com.khmel.task;

import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;
import com.khmel.task.factory.IntArrayFactory;
import com.khmel.task.factory.impl.IntArrayFactoryImpl;
import com.khmel.task.parser.CustomIntParser;
import com.khmel.task.parser.impl.CustomIntParserImpl;
import com.khmel.task.reader.CustomFileReader;
import com.khmel.task.reader.impl.CustomFileReaderImpl;
import com.khmel.task.service.IntArrayAction;
import com.khmel.task.service.IntArraySort;
import com.khmel.task.service.impl.IntArrayActionImpl;
import com.khmel.task.service.impl.IntArraySortImpl;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.OptionalInt;

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

        OptionalInt min = action.min(intArray);
        OptionalInt max = action.max(intArray);
        OptionalInt sum = action.sum(intArray);

        logger.info("Line {} results - Min: {}, Max: {}, Sum: {}",
                i + 1, min.getAsInt(), max.getAsInt(), sum.getAsInt());

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