package org.naptilus.controller;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.naptilus.controller.dto.PriceDto;
import org.naptilus.controller.dto.PriceDtoMapper;
import org.naptilus.domain.Price;
import org.naptilus.queries.FindPricesQuery;
import org.naptilus.queries.FindPricesQueryHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/prices")
@RestController
@AllArgsConstructor
public class PriceController {

  private final FindPricesQueryHandler findPricesQueryHandler;

  private final PriceDtoMapper priceDtoMapper;

  @GetMapping("/")
  public ResponseEntity<PriceDto> getPrice(@RequestParam LocalDateTime startDate, @RequestParam int brandId, @RequestParam int productId) {
    FindPricesQuery findPricesQuery = FindPricesQuery.builder()
        .startDate(startDate)
        .brandId(brandId)
        .productId(productId)
        .build();

    Price price = findPricesQueryHandler.execute(findPricesQuery);
    PriceDto priceDto = priceDtoMapper.asPriceDto(price, startDate);
    return ResponseEntity.ok(priceDto);
  }
}