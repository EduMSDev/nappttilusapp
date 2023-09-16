package org.naptilus.queries;

import reactor.core.CorePublisher;

public interface QueryHandler<T extends Query, R extends CorePublisher<?>> {

  R execute(T query);

}
