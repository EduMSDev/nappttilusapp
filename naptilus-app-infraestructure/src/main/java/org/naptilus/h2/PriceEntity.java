package org.naptilus.h2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prices")
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "price_id")
  private Long priceId;

  @Column(name = "brand_id")
  private int brandId;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "price_list")
  private int priceList;

  @Column(name = "product_id")
  private int productId;

  private int priority;

  private double cost;

  private String currency;
}