<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="/js/member/member.js"></script>
</head>
<body>
<div class="page-wrapper">
    <div class="container-fluid">
        <div class="col-lg-8"><!--게시판 넓이 -->
            <div class="col-lg-12">
                <h1 class="page-header">게시물 상세보기</h1>
            </div>

            <div class="panel panel-default">
<%--                <div class="panel-heading">게시물 상세 </div>--%>
                <div class="panel-body">
                    <table class="table table-hover">
                        <tr>
                            <td>${boardDto.title}
                            </td>
                        </tr>ㅣ
                        <tr>
                            <td>${boardDto.writer}</td>
                            <td>조회수 | ${boardDto.viewCnt}</td>
                            <td>작성일 | ${boardDto.cdate}</td>
                        </tr>
                        <tr>
                            <td>${boardDto.content}</td>
                        </tr>
                        <tr>
                            <td>댓글</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <form id="deleteForm">
            <input type="hidden" name="bno" value="${boardDto.bno}">
            <button type="submit">삭제</button>
        </form>

        <form id="listForm">

            <button type="submit">목록</button>
        </form>

    </div>
</div>

</body>
</html>