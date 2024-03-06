<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/member/join.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body style="height:1200px;">


<div class="container">
    <h1 class="join_title">회원가입</h1>
</div>

<div class="wrapper">
    <form id="join_form" method="post" action="/member/join">

        <!-- 아이디 입력 칸 -->
        <div class="join_id">
            <label class="id_title">아이디</label>
            <div class="id_comment">영문, 숫자를 포함한 8자 이상의 아이디를 입력해주세요.</div>
            <label>
                <input type="text" class="id_input" name="id" placeholder="아이디" id="id">
            </label>
            <span class="final_id_ck">아이디는 영문,숫자로 구성된 6자리 이상 12자리 이내로 작성하세요</span>
            <span class="id_input_re_1">사용 가능한 아이디입니다.</span>
            <span class="id_input_re_2">아이디가 이미 존재합니다.</span>
        </div>
        <!-- 아이디 입력 종료 -->


        <!-- 비밀번호 입력 칸 -->
        <div class="join_password">
            <label class="password_title">비밀번호</label>
            <div class="password_comment">영문,숫자,특수문자를 포함한 8자 이상의 비밀번호를 입력해주세요.</div>
            <label>
                <input type="password" class="password_input" name="password" placeholder="비밀번호" id="pw">
            </label>
            <span class="essential_pw_ck">필수항목입니다!</span>
            <span class="final_pw_ck">비밀번호는 영문,숫자,특수기호를 포함하여 8자 이상이어야 합니다!</span>
        </div>
        <!-- 비밀번호 입력 종료 -->


        <!-- 비밀번호 확인 입력 칸 -->
        <div class="join_password_ck">
            <label class="password_ck_title">비밀번호 확인</label>
            <label>
                <input type="password" class="password_ck_input" name="passwordCk" placeholder="비밀번호 확인" id="pwck">
            </label>
            <span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
            <span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
            <span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
        </div>
        <!-- 비밀번호 확인 입력칸 종료 -->


        <!-- 이름 입력 칸-->
        <div class="join_name">
            <label class="name_title">이름</label>
            <label>
                <input type="text" class="name_input" name="name" placeholder="이름">
            </label>
        </div>
        <!-- 이름 입력 칸 종료-->




        <button class="join_submit" type="submit">회원가입하기</button>
    </form>

</div>
</body>
</html>