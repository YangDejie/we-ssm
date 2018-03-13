<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>登录|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">
</head>
<body ontouchstart>
    <!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">登录注册</div>
    <form class="weui-cells weui-cells_form" action="login" id="login_form" method="post">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">用户ID</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" id="UID" name ="UID" type="number" pattern="[0-9]*" placeholder="请输入你的ID">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label">密码</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="password"  id="passWord" name ="passWord" placeholder="请输入密码">
                </div>
            </div>        
    </form>

        <c:if test= "${not empty user}" >
            <div class="weui-cells__tips" style="color: #04be02;">${user.UID} 已登录</div>
        </c:if>
        <div class="weui-cells__tips">温馨提示：</div>
        <div class="weui-cells__tips">未注册的账号，登录时直接注册</div>
        <div class="weui-cells__tips">已注册的账号，凭账号密码登录</div>
        <div class="weui-cells__tips"></div>
        <input  type="submit" value="确认" form ="login_form" />
        <div class="weui-cells__tips"></div>
    <div class="weui-footer">
            <p class="weui-footer__links">
                <a href="javascript:void(0);" class="weui-footer__link">六度空间</a>
                <a href="../../index.jsp" class="weui-footer__link">返回首页</a>
            </p>
            <p class="weui-footer__text">Copyright © Reserved </p>
    </div>
</div>
</body>
</html>