package com.khmel.task.service.impl;

import com.khmel.task.comparator.IntArrayComparator;
import com.khmel.task.entity.IntArray;
import com.khmel.task.exception.IntArrayException;
import com.khmel.task.repository.IntArrayRepository;
import com.khmel.task.repository.impl.ElementsAmountHigherSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayActionImplTest {
  private IntArrayRepository repository;
  private IntArray array1;
  private IntArray array2;
  private IntArray array3;

  @BeforeEach
  void setUp() throws IntArrayException {
    repository = IntArrayRepository.getInstance();

    array1 = new IntArray(new int[]{1, 2, 3});
    array2 = new IntArray(new int[]{4, 5, 6, 7, 8});
    array3 = new IntArray(new int[]{9, 10});
  }

  @Test
  void testAddAndGet() {
    repository.add(array1);
    repository.add(array2);

    List<IntArray> arrays = repository.getIntArrays();
    assertEquals(2, arrays.size());
    assertTrue(arrays.contains(array1));
    assertTrue(arrays.contains(array2));
  }
}