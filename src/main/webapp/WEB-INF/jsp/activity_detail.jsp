<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>活动详情|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">发布活动</div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">活动ID</label></div>
        <div class="weui-cell__bd">
            <p>${activity.AID}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">所属群</label></div>
        <div class="weui-cell__bd">
            <p>${activity.GID}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">创建者</label></div>
        <div class="weui-cell__bd">
        <p>${activity.createID}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">活动标题</label>
        </div>
        <div class="weui-cell__bd">
            <p> ${activity.title}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">活动时间</label>
        </div>
        <div class="weui-cell__bd">
            <p>${activity.time}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">活动内容</label>
        </div>
        <div class="weui-cell__bd">
            <p>${activity.content}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">报名情况</label>
        </div>
        <div class="weui-cell__bd">
            <p>已报人数：${numbers_done} 最大人数${activity.numbers}</p>
        </div>
    </div>
    <a class="weui-btn weui-btn_primary" href="/join_activity/${activity.AID}" id="showTooltips">我要报名</a>
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