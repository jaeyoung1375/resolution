<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>

                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${selectList}" var="selectList">
                            <tr>
                                <td>${selectList.bno}</td>
                                <td>
                                    <a href="/board/detail?bno=${selectList.bno}">
                                            ${selectList.title}
                                    </a>

                                </td>
                                <td>${selectList.writer}</td>
                                <td>${selectList.cdate}</td>
                                <td>${selectList.viewCnt}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
<br>
<div class="page_wrap">
    <div class="page_nation">


    <c:if test="${vo.showPrev}">
        <a class="arrow prev" href="<c:url value='/board/list?page=${vo.beginPage-1}&pageSize=${vo.pageSize}'/>">&lt;</a>
    </c:if>
    <c:forEach var="i" begin="${vo.beginPage}" end="${vo.endPage}">
        <a class="${i eq vo.page ? 'active' : ''} "
                href="<c:url value='/board/list?page=${i}&pageSize=${vo.pageSize}'/>">${i}</a>

    </c:forEach>
    <c:if test="${vo.showNext}">
        <a class="arrow next" href="<c:url value='/board/list?page=${vo.endPage+1}&pageSize=${vo.pageSize}'/>">&gt;</a>
    </c:if>
    </div>
</div>

</body>
</html>