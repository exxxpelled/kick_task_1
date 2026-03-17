package com.khmel.task.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntArrayStatisticsTest {
  private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};
  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 5;
  private static final int SUM_VALUE = 15;
  private static final int AVG_VALUE = 3;

  @Test
  void constructorWithStatsTest() {
    IntArrayStatistics statistics = new IntArrayStatistics(MIN_VALUE, MAX_VALUE, SUM_VALUE, AVG_VALUE);

    assertEquals(MIN_VALUE, statistics.getMin());
    assertEquals(MAX_VALUE, statistics.getMax());
    assertEquals(SUM_VALUE, statistics.getSum());
    assertEquals(AVG_VALUE, statistics.getAverage());
  }

  @Test
  void constructorWithArrayTest(){
    IntArray intArray = new IntArray(TEST_ARRAY);
    IntArrayStatistics statistics = new IntArrayStatistics(intArray);

    assertEquals(MAX_VALUE, statistics.getMin());
    assertEquals(MAX_VALUE, statistics.getMax());
    assertEquals(SUM_VALUE, statistics.getSum());
    assertEquals(AVG_VALUE, statistics.getAverage());
  }

}