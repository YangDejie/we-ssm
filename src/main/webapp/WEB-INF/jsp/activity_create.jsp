<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>发布活动|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">发布活动</div>
    <form class="weui-cells weui-cells_form" action="create_activity" id="create_activity" method="post">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">群ID</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="GID" name ="GID" type="number" pattern="[0-9]*" placeholder="请输入要发布群的ID">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">活动ID</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="AID" name ="AID" type="number" pattern="[0-9]*" placeholder="请输入你的活动代号">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">活动标题</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="title" name ="title" placeholder="请输入标题">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">活动时间</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="date"  id="time" name ="time">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">活动内容</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="content" name ="content">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">最大人数</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="numbers" name ="numbers" type="number" pattern="[0-9]*" placeholder="请输入你的活动人数">
            </div>
        </div>

    </form>

    <div class="weui-cells__tips"></div>
    <input  type="submit" value="确认" form ="create_activity" />
    <div class="weui-cells__tips"></div>
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