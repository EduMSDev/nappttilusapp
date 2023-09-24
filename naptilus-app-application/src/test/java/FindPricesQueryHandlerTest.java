import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.naptilus.domain.FindPriceFilter;
import org.naptilus.domain.Price;
import org.naptilus.exceptions.PriceNotFoundException;
import org.naptilus.mappers.FindPriceQueryMapper;
import org.naptilus.queries.FindPricesQueryHandler;
import org.naptilus.repository.H2Repository;

@ExtendWith(MockitoExtension.class)
class FindPricesQueryHandlerTest {

  @Mock
  private H2Repository h2Repository;

  @Spy
  private FindPriceQueryMapper priceQueryMapper;

  @InjectMocks
  private FindPricesQueryHandler findPricesQueryHandler;

  @Test
  void execute_shouldOrderPricesByPriority_onSuccess() {
    FindPriceFilter findPriceFilter = ApplicationObjectMother.findPriceFilter();

    when(priceQueryMapper.asPriceFilter(ApplicationObjectMother.findPricesQuery()))
        .thenReturn(findPriceFilter);
    when(h2Repository.findPricesByStartDateBrandIdAndProductId(findPriceFilter))
        .thenReturn(DomainObjectMother.prices());

    Price execute = findPricesQueryHandler.execute(ApplicationObjectMother.findPricesQuery());
    assertEquals(1, execute.getPriority());
  }


  @Test
  void execute_shouldReturnPriceNotFoundException_whenResponseIsEmpty() {
    FindPriceFilter findPriceFilter = ApplicationObjectMother.findPriceFilter();

    when(priceQueryMapper.asPriceFilter(ApplicationObjectMother.findPricesQuery()))
        .thenReturn(findPriceFilter);
    when(h2Repository.findPricesByStartDateBrandIdAndProductId(findPriceFilter))
        .thenReturn(List.of());

    assertThrows(PriceNotFoundException.class, () -> findPricesQueryHandler.execute(ApplicationObjectMother.findPricesQuery()));
  }
}
