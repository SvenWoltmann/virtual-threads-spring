package eu.happycoders.virtualthread.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import eu.happycoders.virtualthread.model.Product;
import eu.happycoders.virtualthread.model.ProductPageResponse;
import eu.happycoders.virtualthread.service.ProductService;
import eu.happycoders.virtualthread.service.SupplierService;
import eu.happycoders.virtualthread.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControllerEvolution1_Sequential {

  private final ProductService productService;
  private final SupplierService supplierService;
  private final WarehouseService warehouseService;

  public ControllerEvolution1_Sequential(
      ProductService productService,
      SupplierService supplierService,
      WarehouseService warehouseService) {
    this.productService = productService;
    this.supplierService = supplierService;
    this.warehouseService = warehouseService;
  }

  @GetMapping("/stage1-seq/product/{productId}")
  public ProductPageResponse getProduct(@PathVariable("productId") String productId) {
    Product product =
        productService
            .getProduct(productId)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

    boolean available = warehouseService.isAvailable(productId);

    int shipsInDays =
        available ? 0 : supplierService.getDeliveryTime(product.supplier(), productId);

    return new ProductPageResponse(product, shipsInDays, Thread.currentThread().toString());
  }
}
