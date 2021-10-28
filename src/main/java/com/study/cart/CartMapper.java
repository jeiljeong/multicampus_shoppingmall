package com.study.cart;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
	int create(CartDTO dto);
}
