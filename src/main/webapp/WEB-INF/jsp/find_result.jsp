<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>查找结果|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">查找结果</div>
    <div class="weui-cell">
        <div class="weui-cell__bd"><label class="weui-label">用户ID</label></div>
        <div class="weui-cell__bd"><label class="weui-label">用户名</label></div>
        <div class="weui-cell__bd"><label class="weui-label">年龄</label></div>
        <div class="weui-cell__bd"><label class="weui-label">管理</label></div>
    </div>
    <c:forEach items="${userList}" var="user">
        <div class="weui-cell">
            <div class="weui-cell__bd"><label class="weui-label">${user.UID}</label></div>
            <div class="weui-cell__bd"><label class="weui-label">${user.userName}</label></div>
            <div class="weui-cell__bd"><label class="weui-label">${user.age}</label></div>
            <div class="weui-cell__bd"> <a class="weui-label" href="/user_detail/${user.UID}">查看详情</a></div>
        </div>
    </c:forEach>








    <div class="weui-footer">
        <p class="weui-footer__links">
            <a href="javascript:void(0);" class="weui-footer__link">六度空间</a>
            <a href="index.html" class="weui-footer__link">返回首页</a>
        </p>
        <p class="weui-footer__text">Copyright © Reserved </p>
    </div>
</div>
</body>
</html>