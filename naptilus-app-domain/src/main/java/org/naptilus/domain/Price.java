package org.naptilus.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

  int brandId;

  LocalDate startDate;

  LocalDate endDate;

  int priceList;

  int productId;

  int priority;

  double cost;

  String currency;
}
