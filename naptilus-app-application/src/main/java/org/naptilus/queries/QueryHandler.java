package org.naptilus.queries;

import org.naptilus.domain.Price;

public interface QueryHandler<T extends Query, R extends Price> {

  R execute(T query);

}
