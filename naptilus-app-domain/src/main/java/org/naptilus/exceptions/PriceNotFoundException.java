package org.naptilus.exceptions;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

  public PriceNotFoundException(LocalDateTime startDate, int brandId, int productId) {
    super(String.format("Price with %s, %s and %s not found", startDate, brandId, productId));
  }
}
