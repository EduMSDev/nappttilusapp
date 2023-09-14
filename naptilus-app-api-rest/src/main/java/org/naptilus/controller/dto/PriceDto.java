package org.naptilus.controller.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriceDto {

  LocalDate startDate;

  LocalDate endDate;

  int priceList;

  int productId;

  int priority;

  double price;

  String currency;
}