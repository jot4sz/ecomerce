package com.ecommerce.api.exception;

public class CustomerNotFoundException extends ResourceNotFoundException {

  public CustomerNotFoundException() {
      super("Customer not found");
  }

  public CustomerNotFoundException(String message) {
        super(message);
  }
}