package org.naptilus.controller.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriceDto {

  LocalDateTime priceDate;

  double finalPrice;

  int productId;

  int brandId;

  int priority;

  double price;

  String currency;
}