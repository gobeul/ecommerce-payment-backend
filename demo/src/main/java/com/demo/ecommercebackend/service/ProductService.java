package com.demo.ecommercebackend.service;

import com.demo.ecommercebackend.domain.Product;
import com.demo.ecommercebackend.dto.ProductCreateRequest;
import com.demo.ecommercebackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 이 클래스가 Spring의 Service Bean임을 알림
@RequiredArgsConstructor // Repository를 주입받기 위한 생성자 자동 생성
public class ProductService {
    private final ProductRepository productRepository; // 의존성 주입 (변경 불가하도록 final)

    @Transactional // 이 메서드가 실행될 때 트랜잭션(데이터 일관성)을 시작함
    public Long createProduct(ProductCreateRequest request) {
        // 1. 요청(DTO)을 바탕으로 Entity 객체를 생성
        Product product = new Product(request.getName(), request.getPrice());

        // 2. Repository를 통해 Entity를 DB에 저장(save)
        Product savedProduct = productRepository.save(product);

        // 3. 저장된 상품의 ID를 반환
        return savedProduct.getId();
    }
}
