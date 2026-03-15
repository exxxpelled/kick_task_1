// task/warehouse/Warehouse.java
package com.khmel.task.warehouse;

import com.khmel.task.entity.IntArrayStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
  private static Logger logger = LogManager.getLogger(Warehouse.class);
  private Map<Integer, IntArrayStatistics> arrayDataMap = new HashMap<>();

  private Warehouse() {
  }

  private static class SingletonHolder {
    private static final Warehouse INSTANCE = new Warehouse();
  }

  public static Warehouse getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public void put(int id, IntArrayStatistics statistics) {
    arrayDataMap.put(id, statistics);
    logger.info("Added statistics for IntArray with id: {}", id);
  }

  public Optional<IntArrayStatistics> get(int id) {
    return Optional.ofNullable(arrayDataMap.get(id));
  }

  public void remove(int id) {
    arrayDataMap.remove(id);
    logger.info("Removed statistics for IntArray with id: {}", id);
  }

  public boolean containsKey(int id) {
    return arrayDataMap.containsKey(id);
  }

  public Map<Integer, IntArrayStatistics> getAll() {
    return new HashMap<>(arrayDataMap);
  }
}