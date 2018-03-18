<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>查看活动|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">浏览活动</div>
    <div class="weui-cell">
        <div class="weui-cell__bd"><label class="weui-label">活动标题</label></div>
        <div class="weui-cell__bd">
            <label class="weui-label">活动时间</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label">活动规模（人）</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label">详情</label>
        </div>
    </div>
    <c:forEach items="${AList}" var="act">
        <div class="weui-cell">
            <div class="weui-cell__bd"><label class="weui-label">${act.title}</label></div>
            <div class="weui-cell__bd"><label class="weui-label"><fmt:formatDate value="${act.time}" pattern="yyyy-MM-dd" /></label></div>
            <div class="weui-cell__bd"><label class="weui-label">${act.numbers}</label></div>
            <div class="weui-cell__bd"><a href="/activity_detail/${act.AID}">详情</a></div>
        </div>
    </c:forEach>

    </div>
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