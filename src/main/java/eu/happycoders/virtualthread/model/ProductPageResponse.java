package eu.happycoders.virtualthread.model;

public record ProductPageResponse(Product product, int daysUntilShippable, String thread) {}
