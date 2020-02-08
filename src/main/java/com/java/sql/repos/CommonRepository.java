package com.java.sql.repos;

import com.java.sql.repos.domain.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigDecimal;

@NoRepositoryBean
public interface CommonRepository<E extends Product> extends CrudRepository<E, Long> {
        Iterable<E> findAllbyPrice(BigDecimal field);

        Iterable<E> findAllbyMaxPrice(BigDecimal field);

        Iterable<E> findAllbyPrice(BigDecimal min,BigDecimal max);
}
