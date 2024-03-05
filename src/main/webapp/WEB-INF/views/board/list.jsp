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

</body>
</html>