package com.demo.ecommercebackend.controller;

import com.demo.ecommercebackend.dto.ProductCreateRequest;
import com.demo.ecommercebackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스가 REST API 컨트롤러임을 알림
@RequestMapping("/products") // 이 컨트롤러의 모든 API는 '/products' 경로로 시작함
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService; // Service 의존성 주입

    // HTTP POST 요청을 '/products' 경로로 받음
    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductCreateRequest request) {
        // @RequestBody: 요청의 JSON 본문(Body)을 ProductCreateRequest 객체로 변환

        // 1. Service를 호출하여 상품 생성 로직을 수행
        Long productId = productService.createProduct(request);

        // 2. 생성된 상품의 ID를 HTTP 200 (OK) 응답으로 반환
        return ResponseEntity.ok(productId);
    }
}
