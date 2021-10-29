class CartService {
	insert(data) {
		return new Promise((resolve, reject) => {
			console.log("insert cart...............");

			$.ajax({
				type: 'post',
				url: './cart/create',
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				success: function(result, status, xhr) {
					resolve(result);
				},
				error: function(xhr, status, er) {
					reject(er);
				}
			});
		});
	}
}