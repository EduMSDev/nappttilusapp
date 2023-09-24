import java.time.LocalDateTime;
import org.naptilus.domain.FindPriceFilter;
import org.naptilus.queries.FindPricesQuery;

public class ApplicationObjectMother {

  public static FindPriceFilter findPriceFilter() {
    return FindPriceFilter.builder()
        .startDate(LocalDateTime.now())
        .brandId(1)
        .productId(1)
        .build();

  }

  public static FindPricesQuery findPricesQuery() {
    return FindPricesQuery.builder()
        .startDate(LocalDateTime.now())
        .brandId(1)
        .productId(1)
        .build();
  }
}