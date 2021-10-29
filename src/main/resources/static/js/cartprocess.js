

addCartBtn.on("click", function (e) {
	if (ordercnt.val() == '') {
		alert("수량을 입력하세요");
		return;
	}
	
	let data = {
		contentsno: contentsno,
		quantity: quantity
	};
	CartService
		.add(data)
		.then(result => {
			alert(result);
			alert("장바구니에 추가되었습니다");
		})
		.catch(e => {
			alert("장바구니 추가에 실패했습니다");
		});
});