package com.study.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.contents.ContentsService;

@Controller
public class CartController {
	@Autowired
	@Qualifier("com.study.cart.CartServiceImpl")
	private CartService service;
	
	@PostMapping("/cart/create/")
	public ResponseEntity<String> create(@RequestBody CartDTO vo, HttpSession session) {
		vo.setId((String)session.getAttribute("id"));
		
		int flag = service.create(vo);
		System.out.println("flag: " + flag);
		return flag == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
