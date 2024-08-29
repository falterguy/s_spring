<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
inputType=["text","number","radio"];
inputName=["coffeemenu","coffeeprice","coffeedecaffein"];


</script>

</head>
<body>
		<form id="fm" method="get" action="/coffee/delete">
		<input type="hidden" name="id" value="${menu.coffeeId }">
	<div id="wrap">
		<a href="/">HOME</a>
		<table id="viewBox">
			<tr>
				<td class="fieldName">커피메뉴</td>
				<td class="value">${coffee.getcoffeemenu() }</td>
			</tr>
			<tr>
				<td class="fieldName">가격</td>
				<td class="value">
					<fmt:setLocale value="en_us"/>
					<fmt:formatNumber value="${coffee.getcoffeeprice() }" type="currency"/>
				</td>
			</tr>
			<tr>
				<td class="fieldName">카페인</td>
				<td class="value">${coffee.getdecaffein() }</td>
			</tr>
			<tr>
				<td cospan="2">
					<button type="button" id="modify">수정</button>
					<button type="button" id="del">삭제</button>		
				</td>
			</tr>
		
		
		</table>
	
	
	</div>
</form>
</body>
</html>