package com.ecomerce.api.exception;

public class ProductNotFoundException extends ResourceNotFoundException {

  public ProductNotFoundException() {
      super("Product not found");
  }

  public ProductNotFoundException(String message) {
        super(message);
    }
}
