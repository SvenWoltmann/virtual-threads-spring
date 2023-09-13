package eu.happycoders.virtualthread.service;

import static eu.happycoders.virtualthread.service.SleepUtil.sleepApproximately;

import eu.happycoders.virtualthread.model.Product;
import eu.happycoders.virtualthread.model.Supplier;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private static final Supplier SUPPLIER1 = new Supplier("Supplier 1", "supplier1.example.com");

  private static final Product PRODUCT1 = new Product("1", "Product 1", SUPPLIER1);

  private static final Product PRODUCT2 = new Product("2", "Product 1", SUPPLIER1);

  public Optional<Product> getProduct(String productId) {
    try {
      sleepApproximately(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return Optional.empty();
    }

    if (productId.equals(PRODUCT1.productId())) {
      return Optional.of(PRODUCT1);
    } else if (productId.equals(PRODUCT2.productId())) {
      return Optional.of(PRODUCT2);
    } else {
      return Optional.empty();
    }
  }

  public CompletableFuture<Optional<Product>> getProductAsync(String productId) {
    return CompletableFuture.supplyAsync(() -> getProduct(productId));
  }
}
