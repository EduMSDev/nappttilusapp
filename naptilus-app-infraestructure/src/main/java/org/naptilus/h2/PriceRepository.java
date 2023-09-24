package org.naptilus.h2;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<PriceEntity, Long> {

  @Query("SELECT p FROM PriceEntity p WHERE productId = ?1 AND brandId = ?2 AND (?3 BETWEEN startDate AND endDate)")
  List<PriceEntity> findByStartDateBrandIdAndProductId(int productId, int brandId, LocalDateTime startDate);
}