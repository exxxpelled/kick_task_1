package com.khmel.task.observer.impl;

import com.khmel.task.entity.IntArray;
import com.khmel.task.entity.IntArrayStatistics;
import com.khmel.task.observer.Observer;
import com.khmel.task.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseObserver implements Observer {
  private static final Logger logger = LogManager.getLogger(WarehouseObserver.class);

  @Override
  public void update(IntArray intArray) {
    IntArrayStatistics statistics = new IntArrayStatistics(intArray);
    Warehouse.getInstance().put(intArray.getId(), statistics);
    logger.info("Warehouse updated for IntArray id: {} - min: {}, max: {}, sum: {}, avg: {}",
            intArray.getId(),
            statistics.getMin(),
            statistics.getMax(),
            statistics.getSum(),
            statistics.getAverage());
  }
}