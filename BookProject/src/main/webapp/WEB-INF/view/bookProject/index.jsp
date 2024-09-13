<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{default}">
<head>
	<title layout:fragment="title">도서관리화면</title>
	<th:block layout:fragment="css"></th:block>
	<th:block layout:fragment="script"></th:block>
</head>
	<div layout:fragment="main" id="main">
	    <div>
            <h2>등록된 도서 목록</h2>
            <ul>
                <li th:each="book : ${bookList}">
                    제목: <span th:text="${book.btitl}"></span><br>
                    이미지: <span th:text="${book.bimg}"></span>
                </li>
            </ul>
        </div>
	</div>
</html>