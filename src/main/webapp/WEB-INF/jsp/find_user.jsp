<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>查找用户|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
<!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">申请入群</h1>
    </div>

    <form class="weui-cells weui-cells_form" action="find_user" id="find_user" method="post">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">昵称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="nickName" name ="nickName" type="text" placeholder="请输入昵称">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">性别</label>
            </div>
            <div class="weui-cell__bd">
                <select class="weui-select" name="sex" id="sex">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">年龄</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number"  id="low_age" name ="low_age" pattern="[0-9]*" placeholder="18">
            </div>
            至
            <div class="weui-cell__bd">
                <input class="weui-input" type="number"  id="high_age" name ="high_age" pattern="[0-9]*" placeholder="28">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">所在地</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="nowLiveAt" name ="nowLiveAt"  placeholder="请输入所在地">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">恋爱状况</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="aboutLove" name ="aboutLove" placeholder="请输入恋爱状况">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">故乡</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="homeTown" name ="homeTown" placeholder="请输入故乡">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">职业</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text"  id="profession" name ="profession" placeholder="请输入职业">
            </div>
        </div>
    </form>
    <div class="weui-cells__tips"></div>
    <input  type="submit" value="搜索" form ="find_user" />
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