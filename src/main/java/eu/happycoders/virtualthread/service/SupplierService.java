package eu.happycoders.virtualthread.service;

import static eu.happycoders.virtualthread.service.SleepUtil.sleepApproximately;

import eu.happycoders.virtualthread.model.Supplier;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

  public int getDeliveryTime(Supplier supplier, String productId) {
    try {
      sleepApproximately(500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return 0;
    }

    return ThreadLocalRandom.current().nextInt(1, 5);
  }

  public CompletableFuture<Integer> getDeliveryTimeAsync(Supplier supplier, String productId) {
    return CompletableFuture.supplyAsync(() -> getDeliveryTime(supplier, productId));
  }
}
