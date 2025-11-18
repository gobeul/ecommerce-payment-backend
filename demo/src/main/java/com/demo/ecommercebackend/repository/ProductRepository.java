package com.demo.ecommercebackend.repository;

import com.demo.ecommercebackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository를 상속받으면 기본적인 CRUD(Save, FindById, Delete 등) 메서드가 자동 구현됨
}
