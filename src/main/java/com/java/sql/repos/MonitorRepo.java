package com.java.sql.repos;

import com.java.sql.repos.domain.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface MonitorRepo extends CommonRepository<Product> {

    @Override
    @Query("SELECT p FROM Monitor p where p.price >= :min")
    Iterable<Product> findAllbyPrice(@Param("min") BigDecimal min);

    @Override
    @Query("SELECT p FROM Monitor p where p.price <= :max")
    Iterable<Product> findAllbyMaxPrice(@Param("max") BigDecimal maxPrice);

    @Override
    @Query("SELECT p " +
            "FROM Monitor p " +
            "where p.price >= :min and p.price <= :max")
    Iterable<Product> findAllbyPrice(@Param("min") BigDecimal minPrice, @Param("max") BigDecimal maxPrice);
}
