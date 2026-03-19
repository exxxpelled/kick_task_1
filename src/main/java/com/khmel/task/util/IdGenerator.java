package com.khmel.task.util;

public final class IdGenerator {
  private static int id = 0;

  public static int getId() {
    return ++id;
  }
}
