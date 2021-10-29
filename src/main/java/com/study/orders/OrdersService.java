package com.study.orders;

import java.util.List;
import java.util.Map;

public interface OrdersService {
	int order(OrdersDTO dto);

	List<OrdersDTO> list(Map map);

	int total(Map map);

	OrdersDTO read(int noticeno);

	int passwd(Map map);

	int update(OrdersDTO dto);

	int delete(int noticeno);

	void upCnt(int noticeno);
}
