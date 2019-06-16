<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css"/>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/hello/admin/saveHello">
    ID:<input type="text" name="helloId"/><br>
    Hello List:<input type="text" name="listHello"/><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
