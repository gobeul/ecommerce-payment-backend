package com.demo.ecommercebackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // JSON -> Java 객체 변환을 위해 기본 생성자가 필요
public class ProductCreateRequest {
    private String name;
    private Integer price;
}
