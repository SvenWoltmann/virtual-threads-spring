package eu.happycoders.virtualthread.service;

import static eu.happycoders.virtualthread.service.SleepUtil.sleepApproximately;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {

  public boolean isAvailable(String productId) {
    try {
      sleepApproximately(500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return false;
    }

    return ThreadLocalRandom.current().nextBoolean();
  }

  public CompletableFuture<Boolean> isAvailableAsync(String productId) {
    return CompletableFuture.supplyAsync(() -> isAvailable(productId));
  }
}
