package org.naptilus.queries;

import com.barcelo.cbe.availability.domain.model.Room;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
@Validated
public class FindPricesQueryHandler implements QueryHandler<FindPricesQuery, Mono<List<List<Room>>>> {

  @Override
  public Mono<List<List<Room>>> execute(FindPricesQuery query) {

  }
}