package com.khmel.task.parser.impl;

import com.khmel.task.exception.IntArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntParserImplTest {
  private CustomIntParserImpl parser;

  @BeforeEach
  void setUp() {
    parser = new CustomIntParserImpl();
  }

  @Test
  void testParseValidLine() throws IntArrayException {
    String line = "1;2;3;4;5";
    int[] result = parser.parseString(line);

    assertNotNull(result);
    assertEquals(5, result.length);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
  }

  @Test
  void testParseLineWithSpaces() throws IntArrayException {
    String line = " 1 ; 2 ; 3 ";
    int[] result = parser.parseString(line);

    assertArrayEquals(new int[]{1, 2, 3}, result);
  }

  @Test
  void testParseEmptyLine() {
    assertThrows(IntArrayException.class, () -> parser.parseString(""));
    assertThrows(IntArrayException.class, () -> parser.parseString("   "));
    assertThrows(IntArrayException.class, () -> parser.parseString(null));
  }

  @Test
  void testParseInvalidNumber() {
    String line = "1;2;abc;4";
    assertThrows(IntArrayException.class, () -> parser.parseString(line));
  }

  @Test
  void testParseEmptyElement() {
    String line = "1;;3;4";
    assertThrows(IntArrayException.class, () -> parser.parseString(line));
  }
}