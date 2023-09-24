import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.naptilus.NapptilusApp;
import org.naptilus.controller.PriceController;
import org.naptilus.controller.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = NapptilusApp.class)
class ApplicationAcceptanceTest {

  @Autowired
  private PriceController priceController;

  @SneakyThrows
  @ParameterizedTest
  @CsvFileSource(resources = "/prices.csv", numLinesToSkip = 1)
  void testApplicationRest(ArgumentsAccessor argumentsAccessor) {

    LocalDateTime dateTime = LocalDateTime.of(
        argumentsAccessor.getInteger(2),
        argumentsAccessor.getInteger(3),
        argumentsAccessor.getInteger(4),
        argumentsAccessor.getInteger(5),
        0
    );

    ResponseEntity<PriceDto> priceResponse = priceController.getPrice(dateTime, argumentsAccessor.getInteger(0), argumentsAccessor.getInteger(1));

    assertEquals(priceResponse.getBody().getBrandId(), argumentsAccessor.getLong(0));
    assertEquals(priceResponse.getBody().getProductId(), argumentsAccessor.getLong(1));
    assertEquals(priceResponse.getBody().getPriceDate(), dateTime);
    assertEquals(priceResponse.getBody().getFinalPrice(), argumentsAccessor.getDouble(6));
    assertEquals(priceResponse.getBody().getPrice(), argumentsAccessor.getDouble(7));


  }

}
