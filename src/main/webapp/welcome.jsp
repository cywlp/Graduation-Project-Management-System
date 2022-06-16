<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/6/6
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .el-carousel__item h3 {
            color: #475669;
            font-size: 18px;
            opacity: 0.75;
            line-height: 300px;
            margin: 0;
        }

        .el-carousel__item:nth-child(2n) {
            background-color: #99a9bf;
        }

        .el-carousel__item:nth-child(2n+1) {
            background-color: #d3dce6;
        }
    </style>
</head>
<body>

    <c:if test="${sessionScope.number != null }">
        <c:if test="${sessionScope.power == 3}">
            <p style="font-size: 35px">欢迎${sessionScope.number}管理员老师来到毕业设计管理系统~~~</p>
        </c:if>
        <c:if test="${sessionScope.power == 2}">
            <p style="font-size: 35px">欢迎${sessionScope.number}老师来到毕业设计管理系统~~~</p>
        </c:if>
        <c:if test="${sessionScope.power == 1}">
            <p style="font-size: 35px">欢迎${sessionScope.number}学生来到毕业设计管理系统~~~</p>
        </c:if>
    </c:if>

</body>
</html>
