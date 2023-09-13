package eu.happycoders.virtualthread.controller;

import eu.happycoders.virtualthread.model.ProductPageResponse;
import eu.happycoders.virtualthread.service.ProductService;
import eu.happycoders.virtualthread.service.SupplierService;
import eu.happycoders.virtualthread.service.WarehouseService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEvolution2_CompletableFuture {

  private final ProductService productService;
  private final SupplierService supplierService;
  private final WarehouseService warehouseService;

  public ControllerEvolution2_CompletableFuture(
      ProductService productService,
      SupplierService supplierService,
      WarehouseService warehouseService) {
    this.productService = productService;
    this.supplierService = supplierService;
    this.warehouseService = warehouseService;
  }

  @GetMapping("/stage2-cf/product/{productId}")
  public CompletionStage<ResponseEntity<ProductPageResponse>> getProduct(
      @PathVariable("productId") String productId) {
    return productService
        .getProductAsync(productId)
        .thenCompose(
            product -> {
              if (product.isEmpty()) {
                return CompletableFuture.completedFuture(ResponseEntity.notFound().build());
              }

              return warehouseService
                  .isAvailableAsync(productId)
                  .thenCompose(
                      available ->
                          available
                              ? CompletableFuture.completedFuture(0)
                              : supplierService.getDeliveryTimeAsync(
                                  product.get().supplier(), productId))
                  .thenApply(
                      daysUntilShippable ->
                          ResponseEntity.ok(
                              new ProductPageResponse(
                                  product.get(),
                                  daysUntilShippable,
                                  Thread.currentThread().toString())));
            });
  }
}
