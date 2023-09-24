import java.util.List;
import org.naptilus.domain.Price;

public class DomainObjectMother {

  private static Price priceWithPriorityOne() {
    return Price.builder().priority(1).build();
  }

  private static Price priceWithPriorityTwo() {
    return Price.builder().priority(2).build();
  }

  public static List<Price> prices() {
    return List.of(priceWithPriorityOne(), priceWithPriorityTwo());
  }
}