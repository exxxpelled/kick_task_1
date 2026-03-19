package com.khmel.task.reader.impl;

import com.khmel.task.exception.IntArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomFileReaderImplTest {
  private CustomFileReaderImpl fileReader;

  @BeforeEach
  void setUp() {
    fileReader = new CustomFileReaderImpl();
  }

  @Test
  void testReadFileWithNullPath() {
    assertThrows(IntArrayException.class, () -> fileReader.readFile(null));
  }

  @Test
  void testReadFileWithEmptyPath() {
    assertThrows(IntArrayException.class, () -> fileReader.readFile(""));
    assertThrows(IntArrayException.class, () -> fileReader.readFile("   "));
  }
}
