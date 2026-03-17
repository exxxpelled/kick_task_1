package com.khmel.task.entity;

import com.khmel.task.exception.IntArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayTest {
  private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};
  private static final int TEST_INDEX = 2;
  private static final int NEW_VALUE = 10;

  private IntArray intArray;

  @BeforeEach
  void setUp() {
    intArray = new IntArray(TEST_ARRAY);
  }

  @Test
  void constructorTest() {
    int id = intArray.getId();
    int length = intArray.length();
    int[] array = intArray.getArray();

    assertTrue(id > 0);
    assertEquals(5, length);
    assertArrayEquals(TEST_ARRAY, array);
  }

  @Test
  void getTest() throws IntArrayException {
    int result = intArray.get(TEST_INDEX);

    assertEquals(3, result);
  }

  @Test
  void getArrayTest() throws IntArrayException {
    int[] arrayCopy = intArray.getArray();
    arrayCopy[0] = 1234;

    assertEquals(1, intArray.get(0));
    assertNotEquals(1234, intArray.get(0));
  }

  @Test
  void setElementTest() throws IntArrayException {
    intArray.setElement(TEST_INDEX, NEW_VALUE);

    assertEquals(NEW_VALUE, intArray.get(TEST_INDEX));
  }

  @Test
  void equalsTest() {
    IntArray sameArray = new IntArray(TEST_ARRAY);
    boolean isSame = intArray.equals(sameArray);

    assertTrue(isSame);
  }

  @Test
  void hashCodeTest() {
    int arrayHashCode = intArray.hashCode();
    int idHashCode = Integer.hashCode(intArray.getId());

    assertEquals(idHashCode, arrayHashCode);
  }
}