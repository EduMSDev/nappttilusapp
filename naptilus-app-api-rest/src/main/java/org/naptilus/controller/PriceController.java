package org.naptilus.controller;


import java.time.LocalDate;
import org.naptilus.controller.dto.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@RequestMapping("/prices")
@Controller
public class PriceController {

  @GetMapping("/")
  public Mono<ResponseEntity<PriceDto>> getPrice(@RequestParam LocalDate startDate, @RequestParam int productId, @RequestParam int brandId) {
    return null;
  }
}
