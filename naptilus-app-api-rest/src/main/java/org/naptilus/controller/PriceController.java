package org.naptilus.controller;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.naptilus.controller.dto.PriceDto;
import org.naptilus.controller.dto.PriceDtoMapper;
import org.naptilus.mappers.PriceQueryMapper;
import org.naptilus.queries.FindPricesQuery;
import org.naptilus.queries.FindPricesQueryHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@RequestMapping("/prices")
@Controller
@AllArgsConstructor
public class PriceController {

  private final PriceQueryMapper priceQueryMapper;

  private final FindPricesQueryHandler findPricesQueryHandler;

  private final PriceDtoMapper priceDtoMapper;

  @GetMapping("/")
  public Mono<ResponseEntity<PriceDto>> getPrice(@RequestParam LocalDate startDate, @RequestParam int brandId, @RequestParam int productId) {
    FindPricesQuery findPricesQuery = FindPricesQuery.builder()
        .startDate(startDate)
        .brandId(brandId)
        .productId(productId)
        .build();

    return findPricesQueryHandler.execute(findPricesQuery)
        .map(priceDtoMapper::asPriceDto)
        .map(ResponseEntity::ok);
  }
}