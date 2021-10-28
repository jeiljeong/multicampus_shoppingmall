package com.study.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.cart.CartServiceImpl")
public class CartServiceImpl implements CartService{
	@Autowired
	private CartMapper mapper;
	
	@Override
	public int create(CartDTO dto) {
		// TODO Auto-generated method stub
		return mapper.create(dto);
	}
}
