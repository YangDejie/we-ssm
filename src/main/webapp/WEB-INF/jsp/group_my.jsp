<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>我的群|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">我创建的群</div>
    <div class="weui-cell">
        <div class="weui-cell__bd"><label class="weui-label">群ID</label></div>
        <div class="weui-cell__bd">
            <label class="weui-label">邀请码</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label">管理</label>
        </div>
    </div>
    <c:forEach items="${cg}" var="group">
        <div class="weui-cell">
            <div class="weui-cell__bd"><label class="weui-label">${group.GID}</label></div>
            <div class="weui-cell__bd">
                <label class="weui-label">${group.inviteCode}</label>
            </div>
            <div class="weui-cell__bd">
                <a class="weui-label" href="manage_group/${group.GID}">管理</a>
            </div>
        </div>
    </c:forEach>


    <div class="weui-cells__title">我加入的群</div>
    <div class="weui-cell">
        <div class="weui-cell__bd"><label class="weui-label">群ID</label></div>
    </div>
    <c:forEach items="${jg}" var="group">
        <div class="weui-cell">
            <div class="weui-cell__bd"><label class="weui-label">${group.GID}</label></div>

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