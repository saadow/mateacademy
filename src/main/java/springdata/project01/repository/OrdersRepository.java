package springdata.project01.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lesson_jpa.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, BigDecimal>{
	@Cacheable("kk11")
	List<Order> findByQtyBetween(BigDecimal minQty, BigDecimal maxQty);
	@Cacheable("orderCached")
	List<Order> findByOrderNumIs(BigDecimal num);
	@Cacheable("kk11")
	List<Order> findByProduct_ProductIdIs(String id);
}
