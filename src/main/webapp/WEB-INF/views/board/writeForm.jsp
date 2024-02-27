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
</head>
<body>
<div class="page-wrapper">
    <div class="container-fluid">
        <div class="col-lg-8"><!--게시판 넓이 -->
            <div class="col-lg-12">
                <h1 class="page-header">게시물 글쓰기</h1>
            </div>

            <div class="panel panel-default">
                <div class="panel-body">

                </div>
            </div>
        </div>
        <form id="writeForm">
            <input type="text" name="title">
            <input type="text" name="content">
            <input type="text" name="writer">
            <button type="submit">등록하기</button>
        </form>


    </div>
</div>
        <script>
           $(document).ready(function(){
            $("#writeForm").click(function(){
                $(this).attr("method","post");
                $(this).attr("action","/board/write");
            });

           });// load end
        </script>
</body>
</html>