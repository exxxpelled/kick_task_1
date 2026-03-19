package com.khmel.task.repository;

import com.khmel.task.entity.IntArray;
import com.khmel.task.observer.impl.WarehouseObserver;
import com.khmel.task.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntArrayRepository {
  private static Logger logger = LogManager.getLogger(IntArrayRepository.class);
  private List<IntArray> intArrays = new ArrayList<>();
  private WarehouseObserver observer = new WarehouseObserver();

  private IntArrayRepository() {
  }

  private static class SingletonHolder {
    private static final IntArrayRepository INSTANCE = new IntArrayRepository();
  }

  public static IntArrayRepository getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public void add(IntArray intArray) {
    intArrays.add(intArray);
    intArray.attach(observer);
    observer.update(intArray);
    logger.info("Added array id={} to repository", intArray.getId());
  }

  public void remove(IntArray intArray) {
    if (intArrays.remove(intArray)) {
      intArray.detach(observer);
      Warehouse.getInstance().remove(intArray.getId());
      logger.info("Removed array id={} from repository and warehouse", intArray.getId());
    }
  }

  public List<IntArray> getIntArrays() {
    return intArrays;
  }

  public List<IntArray> query(Specification specification) {
    List<IntArray> list = intArrays.stream()
            .filter(specification::specify)
            .collect(Collectors.toList());
    return list;
  }

  public List<IntArray> sort(Comparator<IntArray> comparator) {
    List<IntArray> list = intArrays.stream()
            .sorted(comparator)
            .collect(Collectors.toList());
    return list;
  }

}
