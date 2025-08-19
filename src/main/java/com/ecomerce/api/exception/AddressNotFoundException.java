package com.ecomerce.api.exception;

public class AddressNotFoundException extends ResourceNotFoundException {

  public AddressNotFoundException() {
    super("Address not found");
  }

  public AddressNotFoundException(String message) {
    super(message);
  }
}