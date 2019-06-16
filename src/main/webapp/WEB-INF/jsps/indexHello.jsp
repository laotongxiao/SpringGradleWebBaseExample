<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试indexHello</title>
    <link type=text/css rel=stylesheet href="<%=request.getContextPath()%>/resources/css/main.css"/>
</head>
<body>
    <div class="fontColor">传参方式1 取值</div>
    <div>${helloData.helloId}</div>
    <div>${helloData.listHello}</div>
    <div class="fontColor">传参方式2 取值</div>
    <div>${data.helloId}</div>
    <div>${data.listHello}</div>
    <div class="fontColor">传参方式3 取值</div>
    <div>${data.helloId}</div>
    <div>${data.listHello}</div>
</body>
</html>
