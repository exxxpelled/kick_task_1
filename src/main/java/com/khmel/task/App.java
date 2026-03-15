package com.khmel.task;

import com.khmel.task.comparator.IntArrayComparator;
import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;
import com.khmel.task.factory.IntArrayFactory;
import com.khmel.task.factory.impl.IntArrayFactoryImpl;
import com.khmel.task.parser.CustomIntParser;
import com.khmel.task.parser.impl.CustomIntParserImpl;
import com.khmel.task.reader.CustomFileReader;
import com.khmel.task.reader.impl.CustomFileReaderImpl;
import com.khmel.task.repository.IntArrayRepository;
import com.khmel.task.repository.impl.AvgBetweenSpecification;
import com.khmel.task.repository.impl.ElementsAmountHigherSpecification;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class App {
  private static Logger logger = LogManager.getLogger(App.class);
  private static final String FILE_PATH = "data/input.txt";

  public static void main(String[] args) {
    logger.info("Program has been started");

    try {
      CustomFileReader fileReader = new CustomFileReaderImpl();
      CustomIntParser parser = new CustomIntParserImpl();
      IntArrayFactory factory = new IntArrayFactoryImpl();
      IntArrayRepository repository = IntArrayRepository.getInstance();

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
          repository.add(intArray);

          List<IntArray> sortedById = repository.sort(IntArrayComparator.BY_ID);
          logger.info("Sorted by ID: {}", sortedById.size());

          List<IntArray> sortedByLength = repository.sort(IntArrayComparator.BY_ELEMENTS_AMOUNT);
          logger.info("Sorted by length: {}", sortedByLength.size());

          List<IntArray> longArrays = repository.query(new ElementsAmountHigherSpecification(5));
          logger.info("Arrays with >5 elements: {}", longArrays.size());

          List<IntArray> avgInRange = repository.query(new AvgBetweenSpecification(0, 100));
          logger.info("Arrays with avg between 0-100: {}", avgInRange.size());

        } catch (IntArrayException e) {
          logger.error("Error processing line {}: {}", i + 1, e.getMessage());
        }
      }
    } catch (IntArrayException e) {
      logger.error("Fatal error: {}", e.getMessage());
    }

    logger.info("Program has been finished");
  }
}