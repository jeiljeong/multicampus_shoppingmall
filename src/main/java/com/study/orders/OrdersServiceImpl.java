package com.study.orders;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.orders.OrdersServiceImpl")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersMapper mapper;

	@Override
	public int order(OrdersDTO dto) {
		// TODO Auto-generated method stub
		return mapper.order(dto);
	}

	@Override
	public List<OrdersDTO> list(Map map) {
		// TODO Auto-generated method stub
		return mapper.list(map);
	}

	@Override
	public int total(Map map) {
		// TODO Auto-generated method stub
		return mapper.total(map);
	}

	@Override
	public OrdersDTO read(int noticeno) {
		// TODO Auto-generated method stub
		return mapper.read(noticeno);
	}

	@Override
	public int passwd(Map map) {
		// TODO Auto-generated method stub
		return mapper.passwd(map);
	}

	@Override
	public int update(OrdersDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public int delete(int noticeno) {
		// TODO Auto-generated method stub
		return mapper.delete(noticeno);
	}

	@Override
	public void upCnt(int noticeno) {
		mapper.upCnt(noticeno);
	}

}
