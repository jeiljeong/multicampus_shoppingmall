<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>상품 상세정보</title>
<meta charset="utf-8">

<script type="text/javascript">
function checkCnt(f) {
	if(parseInt(f.ordercnt.value) < 1 || 
			parseInt(f.ordercnt.value) > ${dto.stock}) {
		alert("재고 수량보다 주문 수량이 많습니다.");
		f.ordercnt.value="";
		f.ordercnt.focus();
		return false;
	}
}

$(document).ready(function(){
    $("#ordercnt").on("input", function(){
      $("#calctotal").text((parseInt($(this).val()) ? parseInt($(this).val()) : 0) * ${dto.price});
    });
});

</script>
</head>

<!-- contentsno, cateno, pname, price, filename, stock,
		detail -->
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>${dto.pname}</h1>
			<p>
				<br>${dto.detail}</p>
		</div>
		<div class="form-group">
			<div class="col-sm-4">
				<img src="${root}/pstorage/${dto.filename}" class="img-rounded"
					alt="${dto.pname}">
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-heading">재고수량</div>
					<div class="panel-body">${dto.stock}</div>
					<div class="panel-heading">가격</div>
					<div class="panel-body">${dto.price}</div>
				</div>
				<form class="form-horizontal" action="/contents/create"
					method="post" onsubmit="return checkCnt(this)">
					<label for="ordercnt">주문 수량:</label> <input type="text"
						class="form-control" id="ordercnt" placeholder="수량을 입력하세요"
						name="ordercnt"> <br>
					<div class="panel panel-warning">
						<div class="panel-heading">결제 금액</div>
						<div class="panel-body" id="calctotal" style="height:110px;display:table-cell;
						vertical-align:middle;"></div>
					</div>
					<button type="submit" class="btn btn-danger">즉시 구매하기</button>
					<button type="button" class="btn btn-success" onclick="location.href='${root}/admin/list'">장바구니 담기</button>
					<button type="button" class="btn btn-default" onclick="location.href='/contents/mainlist/${dto.cateno}'">목록으로 이동</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
