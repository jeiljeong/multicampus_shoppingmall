package com.study.cart;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.study.orders.OrdersDTO;
import lombok.Data;
 
@Data
public class CartDTO {
	private int   cartno    ;
    private String id       ;
    private int   contentsno;
    private int   quantity  ;
    private int   total     ;
}