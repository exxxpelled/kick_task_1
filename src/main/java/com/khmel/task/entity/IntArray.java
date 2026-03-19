package com.khmel.task.entity;

import com.khmel.task.exception.IntArrayException;
import com.khmel.task.util.IdGenerator;
import com.khmel.task.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArray {
  private static final Logger logger = LogManager.getLogger(IntArray.class);
  private final int id;
  private int[] array;
  private final List<Observer> observers = new ArrayList<>();

  public IntArray(int[] array) {
    this.id = IdGenerator.getId();
    this.array = array.clone();
    logger.info("Created IntArray with id: {}, length: {}", id, array.length);
  }

  public int getId() {
    return id;
  }

  public int length() {
    return array.length;
  }

  public int get(int index) throws IntArrayException {
    if (index < 0 || index >= array.length) {
      throw new IntArrayException("Index out of bounds: " + index);
    }
    return array[index];
  }

  public int[] getArray() {
    return array.clone();
  }

  public void setElement(int index, int value) throws IntArrayException {
    if (index < 0 || index >= array.length) {
      throw new IntArrayException("Index out of bounds: " + index);
    }

    if (array[index] != value) {
      array[index] = value;
      notifyObservers();
      logger.info("Updated element at index {} to value {} for id: {}", index, value, id);
    }
  }

  public void attach(Observer observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
      logger.info("Observer attached to IntArray id: {}", id);
    }
  }

  public void detach(Observer observer) {
    if (observers.remove(observer)) {
      logger.info("Observer detached from IntArray id: {}", id);
    }
  }

  private void notifyObservers() {
    if (!observers.isEmpty()) {
      logger.info("Notifying {} observers for IntArray id: {}", observers.size(), id);
      for (Observer observer : observers) {
        observer.update(this);
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof IntArray other)) return false;
    return Arrays.equals(array, other.getArray());
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  @Override
  public String toString() {
    return "IntArray{id=" + id + ", length=" + array.length + "}";
  }
}